package com.example.__gRPCServer.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.example.helloworld.GreeterGrpc;
import com.example.helloworld.HelloWorldProto.HelloReply;
import com.example.helloworld.HelloWorldProto.HelloRequest;
import io.grpc.stub.StreamObserver;


import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */

public class HelloWorld_Server_1 {
    private static final Logger logger = Logger.getLogger(HelloWorld_Server_1.class.getName());
    private int port = 50051;
    private Server server;
    private void start() throws IOException{
        //建立Service
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        logger.info("Server started, listening on "+ port);
        //ShutdownHook if JVM Shutting
        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run(){

                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorld_Server_1.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }
    private void stop(){
        if (server != null){
            server.shutdown();
        }
    }
    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null){
            server.awaitTermination();
        }
    }


    public  static  void main(String[] args) throws IOException, InterruptedException {

        final HelloWorld_Server_1 server = new HelloWorld_Server_1();
        server.start();
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        //接受參數，然後回傳
        @Override
        public void helloWorld(HelloRequest req,StreamObserver<HelloReply> responseObserver){
            System.out.println("conneting");
            HelloReply reply = HelloReply.newBuilder().setMessage(("Hello "+req.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
            System.out.println("Message from gRPC-Client:" + req.getName());
        }
    }
}