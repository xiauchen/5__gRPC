package com.example.__gRPCServer.grpc.greeter;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *定义接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: helloworldServerStream.proto")
public final class Greeter2Grpc {

  private Greeter2Grpc() {}

  public static final String SERVICE_NAME = "helloworldserverstream.Greeter2";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest,
      com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply> METHOD_HELLO_WORLD_SERVER_STREAM =
      io.grpc.MethodDescriptor.<com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest, com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "helloworldserverstream.Greeter2", "HelloWorldServerStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply.getDefaultInstance()))
          .setSchemaDescriptor(new Greeter2MethodDescriptorSupplier("HelloWorldServerStream"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Greeter2Stub newStub(io.grpc.Channel channel) {
    return new Greeter2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Greeter2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Greeter2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Greeter2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Greeter2FutureStub(channel);
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static abstract class Greeter2ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *一个服务器端流式rpc
     * </pre>
     */
    public void helloWorldServerStream(com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_HELLO_WORLD_SERVER_STREAM, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_HELLO_WORLD_SERVER_STREAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest,
                com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply>(
                  this, METHODID_HELLO_WORLD_SERVER_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter2Stub extends io.grpc.stub.AbstractStub<Greeter2Stub> {
    private Greeter2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter2Stub(channel, callOptions);
    }

    /**
     * <pre>
     *一个服务器端流式rpc
     * </pre>
     */
    public void helloWorldServerStream(com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_HELLO_WORLD_SERVER_STREAM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter2BlockingStub extends io.grpc.stub.AbstractStub<Greeter2BlockingStub> {
    private Greeter2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter2BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *一个服务器端流式rpc
     * </pre>
     */
    public java.util.Iterator<com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply> helloWorldServerStream(
        com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_HELLO_WORLD_SERVER_STREAM, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter2FutureStub extends io.grpc.stub.AbstractStub<Greeter2FutureStub> {
    private Greeter2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter2FutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HELLO_WORLD_SERVER_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Greeter2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Greeter2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO_WORLD_SERVER_STREAM:
          serviceImpl.helloWorldServerStream((com.example.__gRPCServer.HelloWorldServerStreamProto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldServerStreamProto.HelloReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Greeter2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Greeter2BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.__gRPCServer.HelloWorldServerStreamProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter2");
    }
  }

  private static final class Greeter2FileDescriptorSupplier
      extends Greeter2BaseDescriptorSupplier {
    Greeter2FileDescriptorSupplier() {}
  }

  private static final class Greeter2MethodDescriptorSupplier
      extends Greeter2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Greeter2MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (Greeter2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Greeter2FileDescriptorSupplier())
              .addMethod(METHOD_HELLO_WORLD_SERVER_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}