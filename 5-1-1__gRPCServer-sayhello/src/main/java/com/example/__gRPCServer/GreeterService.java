package com.example.__gRPCServer;

import net.devh.boot.grpc.server.service.GrpcService;
//import org.lognet.springboot.grpc.GRpcService;
import io.grpc.stub.StreamObserver;
import com.example.__gRPCServer.HelloProto.HelloRequest;
import com.example.__gRPCServer.HelloProto.HelloReply;

//@GRpcService(interceptors = { LogInterceptor.class })
//@GrpcClient("gRPC server name")
@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "Hello " + request.getName();
        final HelloReply.Builder replyBuilder = HelloReply.newBuilder().setMessage(message);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        System.out.println(message);
    }
}
