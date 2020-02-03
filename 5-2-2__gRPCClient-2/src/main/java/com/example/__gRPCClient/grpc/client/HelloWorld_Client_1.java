package com.example.__gRPCClient.grpc.client;

import com.example.__gRPCClient.grpc.java.Greeter1Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import com.example.__gRPCClient.grpc.greeter.HelloWorldProto.HelloReply;
import com.example.__gRPCClient.grpc.greeter.HelloWorldProto.HelloRequest;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorld_Client_1 {
    private final ManagedChannel channel;
    private final Greeter1Grpc.Greeter1BlockingStub blockingStub;
    private static final Logger logger = Logger.getLogger(HelloWorld_Client_1.class.getName());

    public HelloWorld_Client_1(String host,int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = Greeter1Grpc.newBlockingStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try{
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e)
        {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Message from gRPC-Server: "+response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorld_Client_1 client = new HelloWorld_Client_1("127.0.0.1",50051);
        try{
            String user = "world";
            if (args.length > 0){
                user = args[0];
            }
//            for(int i=0;i<5;i++){
//                client.greet("world:"+i);
//            }
            client.greet(user);
        }finally {
            client.shutdown();
        }
    }
}