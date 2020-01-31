package com.example.__gRPCServer.hello;

import blog.proto.HelloServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

//服务端的实现继承生成的ImplBase类
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(blog.proto.ProtoObj.Person request,
                      io.grpc.stub.StreamObserver<blog.proto.ProtoObj.Result> responseObserver) {
        System.out.println(request.getMyName()+" calling");
        //onNext返回值
        responseObserver.onNext(ProtoObj.Result.newBuilder().setString("hello, "+request.getMyName()).build());
        //服务结束
        responseObserver.onCompleted();
    }
}

//这是一个简单的Server实现
public class HelloServer {
    private int port;
    private Server server;
    public HelloServer(int port) throws IOException {
        this.port=port;
        //server的builder
        server= ServerBuilder.forPort(port).addService(new HelloServiceImpl()).build();
        //开始服务器
        server.start();
        System.out.println("Server started, listening on " + port );
    }

    private void blockUntilShutdown() throws InterruptedException {
        while(true){
            server.awaitTermination();
        }
    }
    public static void main(String[] args) throws Exception {
        //启动8080端口并block线程
        (new HelloServer(8080)).blockUntilShutdown();
    }
}