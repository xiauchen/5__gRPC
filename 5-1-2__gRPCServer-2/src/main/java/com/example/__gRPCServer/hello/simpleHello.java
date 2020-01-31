//package com.example.__gRPCServer.hello;
//
//import blog.proto.HelloServiceGrpc;
//
//public class simpleHello implements HelloServiceGrpc.HelloServiceImplBase {
//    @Override
//    public void simpleHello(ProtoObj.Person request,
//                            io.grpc.stub.StreamObserver<ProtoObj.Result> responseObserver) {
//        //返回结果
//        responseObserver.onNext(ProtoObj.Result.newBuilder().setString("hello, "+request.getMyName()).build());
//        responseObserver.onCompleted();
//    }
//}
