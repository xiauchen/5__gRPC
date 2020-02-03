//package com.example.__gRPCClient.grpc.client;
//
//import com.example.__gRPCClient.grpc.GreeterGrpc;
//import com.example.__gRPCClient.grpc.HelloWorldProto.HelloReply;
//import com.example.__gRPCClient.grpc.HelloWorldProto.HelloRequest;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.StatusRuntimeException;
//
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Created by wly on 18/8/15.
// */
//public class HelloWorldClientAndServerStream_Client_4 {
//    private final ManagedChannel channel;
//    private final GreeterGrpc.GreeterBlockingStub blockingStub;
//    private static final Logger logger = Logger.getLogger(HelloWorldClientAndServerStream_Client_4.class.getName());
//
//    public HelloWorldClientAndServerStream_Client_4(String host, int port){
//        channel = ManagedChannelBuilder.forAddress(host,port)
//                .usePlaintext(true)
//                .build();
//
//        blockingStub = GreeterGrpc.newBlockingStub(channel);
//    }
//
//
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }
//
//    public  void greet(String name){
//        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
//        HelloReply response;
//        try{
//            response = blockingStub.HelloWorldClientAndServerStream(request);
//        } catch (StatusRuntimeException e)
//        {
//            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
//            return;
//        }
//        logger.info("Message from gRPC-Server: "+response.getMessage());
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4("127.0.0.1",50051);
//        try{
//            String user = "world";
//            if (args.length > 0){
//                user = args[0];
//            }
//            client.greet(user);
//        }finally {
//            client.shutdown();
//        }
//    }
//}