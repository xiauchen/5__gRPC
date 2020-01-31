package com.example.__gRPCClient.hello;

import blog.proto.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    private static Object ProtoObj;

    public static void  main(String[] args){
        //grpc的channel
        ManagedChannel channel= ManagedChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext(true).build();
        //构建服务的stub
        HelloServiceGrpc.HelloServiceBlockingStub stub= HelloServiceGrpc.newBlockingStub(channel);
        ProtoObj.Person person=ProtoObj.Person.newBuilder().setMyName("World").build();
        //调用方法
        System.out.println(stub.hello(person).getString());
        //关闭channel，不然服务端会报错“远程主机强迫关闭了一个现有的连接。”
        channel.shutdown();
    }
}