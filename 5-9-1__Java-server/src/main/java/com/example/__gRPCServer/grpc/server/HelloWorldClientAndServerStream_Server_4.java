package com.example.__gRPCServer.grpc.server;

import grpc.health.v1.HealthGrpc;
import grpc.health.v1.HealthOuterClass.HealthCheckRequest;
import grpc.health.v1.HealthOuterClass.HealthCheckResponse;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloReply;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.NotRegisteredException;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Value;
//import net.devh.boot.grpc.server.service.GrpcService;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * Created by wly on 18/8/15.
 */
public class HelloWorldClientAndServerStream_Server_4 {
    private static final Logger logger = Logger.getLogger(HelloWorldClientAndServerStream_Server_4.class.getName());

    @Value("${management.server.port}")
    private int port = 49993;
    private Server server;

    public void start(int lPort) throws IOException, NotRegisteredException {
        port = lPort;
        //建立Service
        server = ServerBuilder.forPort(lPort)
                .addService(new GreeterImpl())
                .addService(new HealthImpl())
                .build()
                .start();
        logger.info("Server started, listening on "+ lPort);
        //consul register
        Consul client = Consul.builder().build();
        AgentClient agentClient = client.agentClient();
        String serviceId = String.valueOf(lPort);
//        Registration.RegCheck ttlCheck = ImmutableRegCheck.builder().ttl("60s").deregisterCriticalServiceAfter("1m").build();
//        ImmutableRegCheck check = ImmutableRegCheck.builder().tcp("http://127.0.0.1:49992/actuator/health").interval("5s").build();
        ImmutableRegCheck check = ImmutableRegCheck.builder().grpc("host.docker.internal:"+lPort).interval("5s").build();
        Registration service = ImmutableRegistration.builder()
                .id(serviceId)
                .name("gRPCA"+lPort)
                .port(lPort)
                .addChecks(check)
//                .check(Registration.RegCheck.ttl(60L)) // registers with a TTL of 3 seconds
//                .check(ImmutableRegCheck.builder()
//                        .grpc("127.0.0.1:"+lPort)
//                        .interval("5s")
////                        .deregisterCriticalServiceAfter("1m")
//                        .build())
                .tags(Collections.singletonList("tag3"))
                .meta(Collections.singletonMap("version", "1.0"))
                .build();
        agentClient.register(service);
        // Check in with Consul (serviceId required only).
        // Client will prepend "service:" for service level checks.
        // Note that you need to continually check in before the TTL expires, otherwise your service's state will be marked as "critical".
//        agentClient.pass(serviceId);
        //ShutdownHook if JVM Shutting
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldClientAndServerStream_Server_4.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop(){
        if (server != null){
            server.shutdown();
        }
    }

    // block 一直到退出程序
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null){
            server.awaitTermination();
        }
    }


    public  static  void main(String[] args) throws IOException, InterruptedException, NotRegisteredException {

        final HelloWorldClientAndServerStream_Server_4 server = new HelloWorldClientAndServerStream_Server_4();
        server.start(49993);
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
//    @GRpcService(grpcServiceOuterClass = GreeterGrpc.class)
//    @GrpcService
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        //接受參數，然後回傳
        @Override
        public void sayHello(HelloRequest req,StreamObserver<HelloReply> responseObserver){
            HelloReply reply = HelloReply.newBuilder().setMessage(("Hello "+req.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
//            System.out.println("Message from gRPC-Client:" + req.getName());
        }
    }

    private class HealthImpl extends HealthGrpc.HealthImplBase {

        @Override
        public void check(HealthCheckRequest healthCheckRequest,StreamObserver<HealthCheckResponse> responseObserver){
            HealthCheckResponse healthCheckResponse = HealthCheckResponse.newBuilder().setStatusValue(1).build();
            responseObserver.onNext(healthCheckResponse);
            responseObserver.onCompleted();
        }

        @Override
        public void watch(HealthCheckRequest healthCheckRequest,StreamObserver<HealthCheckResponse> responseObserver){
            System.out.println("watch");
            HealthCheckResponse healthCheckResponse = HealthCheckResponse.newBuilder().setStatusValue(1).build();
            responseObserver.onNext(healthCheckResponse);
            responseObserver.onCompleted();
        }
    }

}