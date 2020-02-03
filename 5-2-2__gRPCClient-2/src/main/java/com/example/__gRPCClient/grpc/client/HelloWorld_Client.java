package com.example.__gRPCClient.grpc.client;

import com.example.__gRPCClient.Greeter1Grpc;
import com.example.__gRPCClient.HelloWorldProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorld_Client {
    private final ManagedChannel channel;
    private final Greeter1Grpc.Greeter1BlockingStub blockingStub;
    private static final Logger logger = Logger.getLogger(HelloWorld_Client.class.getName());

    public HelloWorld_Client(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = Greeter1Grpc.newBlockingStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void greet(String name){
        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder().setName(name).build();
        HelloWorldProto.HelloReply response;
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
        HelloWorld_Client client = new HelloWorld_Client("127.0.0.1",50051);
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