package com.example.__gRPCClient.grpc;

import com.example.__gRPCClient.GreeterGrpc;
import com.example.__gRPCClient.HelloProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HelloClient {
    private static final Logger logger = Logger.getLogger(HelloClient.class.getName());
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;
    /** Construct client connecting to HelloWorld server at {@code host:port}. */
// 首先，我們需要為stub建立一個grpc的channel，指定我們連線服務端的地址和埠
// 使用ManagedChannelBuilder方法來建立channel
    public HelloClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
// Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
// needing certificates.
                .usePlaintext(true)
                .build();
// 使用我們從proto檔案生成的GreeterGrpc類提供的newBlockingStub方法指定channel建立stubs
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
// 呼叫服務端方法
    /** Say hello to server. */
    public <HelloReply> void greet(String name) {
        logger.info("Will try to greet "  + name  + " ...");
// 建立並定製protocol buffer物件，使用該物件呼叫服務端的sayHello方法，獲得response
        HelloProto.HelloRequest request = HelloProto.HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = (HelloReply) blockingStub.sayHello(request);
// 如果有異常發生，則異常被編碼成Status，可以從StatusRuntimeException異常中捕獲
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: "+  response.toString());
    }
    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        HelloClient client = new HelloClient("localhost", 50051);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "hans";
            if (args.length > 0) {
                user = args[0]; /* Use the arg as the name to greet if provided */
            }
            client.greet(user);
        } finally {
            client.shutdown();
        }
    }
}