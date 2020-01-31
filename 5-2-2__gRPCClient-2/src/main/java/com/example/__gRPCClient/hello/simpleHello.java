//package com.example.__gRPCClient.hello;
//
//public class simpleHello {
//    @Test
//    public void  simple() throws InterruptedException {
//
//        final ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext(true).build();
//        //定义同步阻塞的stub
//        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);
//
//        ProtoObj.Person person = ProtoObj.Person.newBuilder().setMyName("World").build();
//        //simple
//        System.out.println("---simple rpc---");
//        System.out.println(blockingStub.simpleHello(person).getString());
//        channel.shutdown();
//    }
//}
