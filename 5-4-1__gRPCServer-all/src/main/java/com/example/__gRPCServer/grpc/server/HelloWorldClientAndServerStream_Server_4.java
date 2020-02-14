package com.example.__gRPCServer.grpc.server;

import com.example.helloworld.GreeterGrpc;
import com.example.helloworld.HelloWorldProto.HelloReply;
import com.example.helloworld.HelloWorldProto.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloWorldClientAndServerStream_Server_4 {
    private static final Logger logger = Logger.getLogger(HelloWorldClientAndServerStream_Server_4.class.getName());


    private int port = 50054;
    private Server server;

    public void start() throws IOException{
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
                HelloWorldClientAndServerStream_Server_4.this.stop();
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
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null){
            server.awaitTermination();
        }
    }


    public  static  void main(String[] args) throws IOException, InterruptedException {

        final HelloWorldClientAndServerStream_Server_4 server = new HelloWorldClientAndServerStream_Server_4();
        server.start();
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        //接受參數，然後回傳
        @Override
        public StreamObserver<HelloRequest> helloWorldClientAndServerStream(StreamObserver<HelloReply> responseObserver){
            return new StreamObserver<HelloRequest>(){
                private HelloReply.Builder builder=HelloReply.newBuilder();
                @Override
                public void onNext(HelloRequest helloRequest) {
                    responseObserver.onNext(HelloReply.newBuilder().setMessage("hello 1 , "+helloRequest.getName()).build());
                    responseObserver.onNext(HelloReply.newBuilder().setMessage("hello 2 , "+helloRequest.getName()).build());
                    responseObserver.onNext(HelloReply.newBuilder().setMessage("hello 3 , "+helloRequest.getName()).build());
                    logger.log(Level.WARNING, "bidirectional stream--"+helloRequest.getName());
                }
                @Override
                public void onError(Throwable t) {
                }
                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}