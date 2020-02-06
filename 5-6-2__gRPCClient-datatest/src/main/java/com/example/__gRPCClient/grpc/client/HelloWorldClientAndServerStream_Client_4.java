package com.example.__gRPCClient.grpc.client;

import com.example.helloworld.GreeterGrpc;
import com.example.helloworld.HelloWorldProto.HelloReply;
import com.example.helloworld.HelloWorldProto.HelloRequest;
import com.example.__gRPCClient.grpc.client.LocalNameResolverFactory.LocalNameResolverProvider;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import io.grpc.NameResolver.Args;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorldClientAndServerStream_Client_4 {
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterStub asyncStub;
    private static final Logger logger = Logger.getLogger(HelloWorldClientAndServerStream_Client_4.class.getName());

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

        asyncStub = GreeterGrpc.newStub(channel);
    }

    public HelloWorldClientAndServerStream_Client_4(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        asyncStub = GreeterGrpc.newStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        StreamObserver<HelloReply> responseObserver = new StreamObserver<HelloReply>() {
            @Override
            public void onNext(HelloReply reply) {
                logger.log(Level.WARNING, "bidirectional stream--"+reply.getMessage());
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                channel.shutdown();
            }
        };
        try{
            StreamObserver<HelloRequest> response = asyncStub.helloWorldClientAndServerStream(responseObserver);
            response.onNext(HelloRequest.newBuilder().setName("world" + "1").build());
            response.onNext(HelloRequest.newBuilder().setName(name + "2").build());
            response.onNext(HelloRequest.newBuilder().setName(name + "3").build());
            response.onCompleted();
            Thread.sleep(3000);
        } catch (StatusRuntimeException | InterruptedException e)
        {
            logger.log(Level.WARNING, "RPC failed: {0}", e.toString());
            return;
        }
//        logger.info("Message from gRPC-Server: "+ responseObserver.toString());
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