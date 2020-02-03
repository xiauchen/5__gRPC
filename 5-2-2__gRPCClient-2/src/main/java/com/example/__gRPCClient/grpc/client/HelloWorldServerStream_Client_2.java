package com.example.__gRPCClient.grpc.client;

import com.example.__gRPCClient.Greeter2Grpc;
import com.example.__gRPCClient.HelloWorldServerStreamProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorldServerStream_Client_2 {
    private final ManagedChannel channel;
    private final Greeter2Grpc.Greeter2BlockingStub blockingStub;
    private static final Logger logger = Logger.getLogger(HelloWorldServerStream_Client_2.class.getName());

    public HelloWorldServerStream_Client_2(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = Greeter2Grpc.newBlockingStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void greet(String name){
        HelloWorldServerStreamProto.HelloRequest request = HelloWorldServerStreamProto.HelloRequest.newBuilder().setName(name).build();
        Iterator<HelloWorldServerStreamProto.HelloReply> response;
        try{
            response = blockingStub.helloWorldServerStream(request);
        } catch (StatusRuntimeException e)
        {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        while (response.hasNext()) {
            logger.info("Message from gRPC-Server: " + response.next());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldServerStream_Client_2 client = new HelloWorldServerStream_Client_2("127.0.0.1",50051);
        try{
            String user = "world";
            if (args.length > 0){
                user = args[0];
            }
            client.greet(user);
        }finally {
            client.shutdown();
        }
    }
}