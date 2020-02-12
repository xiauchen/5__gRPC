package com.example.__gRPCClient.grpc.client;

import com.example.helloworld.GreeterGrpc;
import com.example.helloworld.HelloWorldProto.HelloReply;
import com.example.helloworld.HelloWorldProto.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorldClientStream_Client_3 {
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterStub asyncStub;
    private static final Logger logger = Logger.getLogger(HelloWorldClientStream_Client_3.class.getName());

    public HelloWorldClientStream_Client_3(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();
        //異步的stub
        asyncStub = GreeterGrpc.newStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        StreamObserver<HelloReply> responseObserver = new StreamObserver<HelloReply>() {
            @Override
            public void onNext(HelloReply result) {
                logger.log(Level.WARNING,"client stream--" + result.getMessage());
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                //关闭channel
                channel.shutdown();
            }
        };

        try{
            StreamObserver<HelloRequest> response = asyncStub.helloWorldClientStream(responseObserver);
            response.onNext(HelloRequest.newBuilder().setName("world" + "1").build());
            response.onNext(HelloRequest.newBuilder().setName(name + "2").build());
            response.onNext(HelloRequest.newBuilder().setName(name + "3").build());
            response.onCompleted();
            //由于是异步获得结果，所以sleep一秒
            Thread.sleep(3000);
        } catch (StatusRuntimeException | InterruptedException e)
        {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return;
        }
//        logger.info("Message from gRPC-Server: "+responseObserver.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClientStream_Client_3 client = new HelloWorldClientStream_Client_3("127.0.0.1",50053);

        try{
            String user = " world";
            if (args.length > 0){
                user = args[0];
            }
            client.greet(user);
        }finally {
            client.shutdown();
        }
    }
}