//package com.example.__gRPCServer;
//
//import com.example.helloworld.GreeterGrpc;
//import com.example.helloworld.HelloWorldProto;
//import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;
//
//@GrpcService
//public class gRpcGreeterImpl extends GreeterGrpc.GreeterImplBase {
//    //接受參數，然後回傳
//    @Override
//    public StreamObserver<HelloWorldProto.HelloRequest> helloWorldClientAndServerStream(StreamObserver<HelloWorldProto.HelloReply> responseObserver){
//        return new StreamObserver<HelloWorldProto.HelloRequest>(){
//            private HelloWorldProto.HelloReply.Builder builder= HelloWorldProto.HelloReply.newBuilder();
//            @Override
//            public void onNext(HelloWorldProto.HelloRequest helloRequest) {
//                responseObserver.onNext(HelloWorldProto.HelloReply.newBuilder().setMessage(":hello 1 , "+helloRequest.getName()).build());
//                responseObserver.onNext(HelloWorldProto.HelloReply.newBuilder().setMessage(":hello 2 , "+helloRequest.getName()).build());
//                responseObserver.onNext(HelloWorldProto.HelloReply.newBuilder().setMessage(":hello 3 , "+helloRequest.getName()).build());
//            }
//
//
//            @Override
//            public void onError(Throwable t) {
//            }
//
//            @Override
//            public void onCompleted() {
//                responseObserver.onCompleted();
//            }
//        };
//    }
//}
