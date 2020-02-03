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
//public class HelloWorldClientStream_Client_3 {
//    private final ManagedChannel channel;
//    private final GreeterGrpc.GreeterBlockingStub asyncStub;
//    private static final Logger logger = Logger.getLogger(HelloWorldClientStream_Client_3.class.getName());
//
//    public HelloWorldClientStream_Client_3(String host, int port){
//        channel = ManagedChannelBuilder.forAddress(host,port)
//                .usePlaintext(true)
//                .build();
//
//        asyncStub = GreeterGrpc.newBlockingStub(channel);
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
//
//        StreamObserver<ProtoObj.Result> responseObserver = new StreamObserver<ProtoObj.Result>() {
//            @Override
//            public void onNext(ProtoObj.Result result) {
//                System.out.println("client stream--" + result.getString());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//            }
//
//            @Override
//            public void onCompleted() {
//                //关闭channel
//                channel.shutdown();
//            }
//        };
//
//        try{
//            StreamObserver<ProtoObj.Person> clientStreamObserver = asyncStub.clientStreamHello(responseObserver);
//            clientStreamObserver.onNext(ProtoObj.Person.newBuilder().setMyName("World").build());
//            clientStreamObserver.onNext(ProtoObj.Person.newBuilder().setMyName("World2").build());
//            clientStreamObserver.onCompleted();
//            //由于是异步获得结果，所以sleep一秒
//            Thread.sleep(1000);
//        } catch (StatusRuntimeException e)
//        {
//            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
//            return;
//        }
//        logger.info("Message from gRPC-Server: "+response.getMessage());
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        HelloWorldClientStream_Client_3 client = new HelloWorldClientStream_Client_3("127.0.0.1",50051);
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