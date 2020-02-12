package com.example.__gRPCClient.grpc.client;

import com.example.helloworld.GreeterGrpc;
import grpc.health.v1.HealthOuterClass.HealthCheckResponse;
import grpc.health.v1.HealthOuterClass.HealthCheckRequest;
import grpc.health.v1.HealthGrpc;
import com.example.helloworld.HelloWorldProto;
import com.example.helloworld.HelloWorldProto.HelloReply;
import com.example.helloworld.HelloWorldProto.HelloRequest;
import com.example.__gRPCClient.grpc.client.LocalNameResolverFactory.LocalNameResolverProvider;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import io.grpc.NameResolver.Args;


import javax.xml.crypto.Data;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorldClientAndServerStream_Client_4 {
    private final ManagedChannel channel;
    private final ManagedChannel channel_h;
    private final GreeterGrpc.GreeterStub asyncStub;
    private final GreeterGrpc.GreeterBlockingStub blockingStub_h;
    private final HealthGrpc.HealthBlockingStub blockingStub;
    private static final Logger logger = Logger.getLogger(HelloWorldClientAndServerStream_Client_4.class.getName());
    private String finalString;
    private int test1 = 0;
    /**
     * Consul NameResolver Usage.
     *
     *
     * @param serviceName consul service name.
     * @param consulHost consul agent host.
     * @param consulPort consul agent port.
     * @param ignoreConsul if true, consul is not used. instead, the static node list will be used.
     * @param hostPorts the static node list, for instance, Arrays.asList("host1:port1", "host2:port2")
     */
    public HelloWorldClientAndServerStream_Client_4(
                                            String consulHost,
                                            int consulPortA,
                                            int consulPortB,
                                            int ignoreConsul) throws URISyntaxException {

        String consulAddr = "consul://" + consulHost;
        List<Integer> listConsulPort = new ArrayList<>();
        listConsulPort.add(consulPortA);
        listConsulPort.add(consulPortB);


        channel = ManagedChannelBuilder
                .forTarget(consulAddr)
                .defaultLoadBalancingPolicy("pick_first")
//                .defaultLoadBalancingPolicy("round_robin")
                .nameResolverFactory(new LocalNameResolverProvider(consulHost,listConsulPort))
//                .nameResolverFactory(new ConsulNameResolver.ConsulNameResolverProvider(serviceName, pauseInSeconds, ignoreConsul, hostPorts))
                .usePlaintext(true)
                .build();
        channel_h = ManagedChannelBuilder.forAddress(consulHost,consulPortA)
                .usePlaintext(true)
                .build();
        blockingStub_h = GreeterGrpc.newBlockingStub(channel_h);
        asyncStub = GreeterGrpc.newStub(channel);
        blockingStub = HealthGrpc.newBlockingStub(channel);
    }

    public HelloWorldClientAndServerStream_Client_4(String host, int port){
        channel_h = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();
        blockingStub_h = GreeterGrpc.newBlockingStub(channel_h);
        channel = null;
        asyncStub = GreeterGrpc.newStub(channel_h);
        blockingStub = null;
    }


    public void shutdown() throws InterruptedException {
        if(channel != null)
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        channel_h.shutdown();
    }

    public void greet(String name){
        long time1 = System.currentTimeMillis();
        HealthCheckResponse healthCheckResponse;
        HealthCheckRequest healthRequest = HealthCheckRequest.newBuilder().setService(name).build();
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        StreamObserver<HelloReply> responseObserver = new StreamObserver<HelloReply>() {
            @Override
            public void onNext(HelloReply reply) {
//                logger.log(Level.WARNING, "bidirectional stream--"+reply.getMessage());
                finalString = reply.getMessage() + new Date() + test1;
                test1++;
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                if(channel != null)
                    channel.shutdown();
                if (channel_h != null)
                    channel_h.shutdown();
                System.out.println(finalString);
                long time2 = System.currentTimeMillis();
                System.out.println((time2-time1)/1000.0 + "秒");
            }
        };
        try{
            StreamObserver<HelloRequest> response = asyncStub.helloWorldClientAndServerStream(responseObserver);
            for (int i = 0 ;i<10000;i++)
                response.onNext(HelloRequest.newBuilder().setName("world" + "1" + i).build());
            response.onCompleted();
//            Thread.sleep(1200);
        } catch (StatusRuntimeException e)
        {
            logger.log(Level.WARNING, "RPC failed: {0}", e.toString());
            return;
        }
//        logger.info("Message from gRPC-Server: "+ healthCheckResponse.toString());
    }

    public void getGreet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response = null;
        try{
            long time1 = System.currentTimeMillis();
            for(int i =0 ;i<10000;i++)
                response = blockingStub_h.helloWorld(request);
            long time2 = System.currentTimeMillis();
            System.out.println((time2-time1)/1000.0 + "秒");
        } catch (StatusRuntimeException e)
        {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Message from gRPC-Server: "+response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4("127.0.0.1",50054);
        try{
            String user = "world";
            if (args.length > 0){
                user = args[0];
            }
            client.greet(user);
        }finally {
            client.shutdown();
        }
    }
}