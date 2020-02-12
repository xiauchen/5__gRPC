//package com.example.__gRPCServer.grpc;
//
//import com.example.__gRPCServer.GreeterGrpc;
//import com.example.__gRPCServer.HelloProto;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import io.grpc.stub.StreamObserver;
//
//import java.io.IOException;
//import java.util.logging.Logger;
//public class HelloServer {
//    private static final Logger logger = Logger.getLogger(HelloServer.class.getName());
//    private int port = 50051;
//    private Server server;
//    private void start() throws IOException {
//// 使用ServerBuilder來構建和啟動服務，通過使用forPort方法來指定監聽的地址和埠
//// 建立一個實現方法的服務GreeterImpl的例項，並通過addService方法將該例項納入
//// 呼叫build() start()方法構建和啟動rpcserver
//        server = ServerBuilder.forPort(port)
//                .addService(new GreeterImpl())
//                .build()
//                .start();
//        logger.info("Server started, listening on "  + port);
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//// Use stderr here since the logger may have been reset by its JVM shutdown hook.
//                System.err.println("*** shutting down gRPC server since JVM is shutting down");
//                HelloServer.this.stop();
//                System.err.println("*** server shut down");
//            }
//        });
//    }
//    private void stop() {
//        if (server != null) {
//            server.shutdown();
//        }
//    }
//    /**
//     * Await termination on the main thread since the grpc library uses daemon threads.
//     */
//    private void blockUntilShutdown() throws InterruptedException {
//        if (server != null) {
//            server.awaitTermination();
//        }
//    }
//    /**
//     * Main launches the server from the command line.
//     */
//    public static void main(String[] args) throws IOException, InterruptedException {
//        final HelloServer server = new HelloServer();
//        server.start();
//        server.blockUntilShutdown();
//    }
//    // 我們的服務GreeterImpl繼承了生成抽象類GreeterGrpc.GreeterImplBase，實現了服務的所有方法
//    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
//        @Override
//        public void sayHello(HelloProto.HelloRequest req, StreamObserver<HelloProto.HelloReply> responseObserver) {
//            HelloProto.HelloReply reply = HelloProto.HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
//// 使用響應監視器的onNext方法返回HelloReply
//            responseObserver.onNext(reply);
//// 使用onCompleted方法指定本次呼叫已經完成
//            responseObserver.onCompleted();
//        }
//    }
//}