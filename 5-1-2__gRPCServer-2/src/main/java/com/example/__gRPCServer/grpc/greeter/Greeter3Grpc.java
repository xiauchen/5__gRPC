package com.example.__gRPCServer.grpc.greeter;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *定义接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: helloworldClientStream.proto")
public final class Greeter3Grpc {

  private Greeter3Grpc() {}

  public static final String SERVICE_NAME = "helloworldclientstream.Greeter3";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloRequest,
      com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply> METHOD_HELLO_WORLD_CLIENT_STREAM =
      io.grpc.MethodDescriptor.<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloRequest, com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "helloworldclientstream.Greeter3", "HelloWorldClientStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.__gRPCServer.HelloWorldClientStreamProto.HelloRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply.getDefaultInstance()))
          .setSchemaDescriptor(new Greeter3MethodDescriptorSupplier("HelloWorldClientStream"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Greeter3Stub newStub(io.grpc.Channel channel) {
    return new Greeter3Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Greeter3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Greeter3BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Greeter3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Greeter3FutureStub(channel);
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static abstract class Greeter3ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *一个客户端流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloRequest> helloWorldClientStream(
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_HELLO_WORLD_CLIENT_STREAM, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_HELLO_WORLD_CLIENT_STREAM,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.example.__gRPCServer.HelloWorldClientStreamProto.HelloRequest,
                com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply>(
                  this, METHODID_HELLO_WORLD_CLIENT_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter3Stub extends io.grpc.stub.AbstractStub<Greeter3Stub> {
    private Greeter3Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter3Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter3Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter3Stub(channel, callOptions);
    }

    /**
     * <pre>
     *一个客户端流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloRequest> helloWorldClientStream(
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_HELLO_WORLD_CLIENT_STREAM, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter3BlockingStub extends io.grpc.stub.AbstractStub<Greeter3BlockingStub> {
    private Greeter3BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter3BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter3BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter3BlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter3FutureStub extends io.grpc.stub.AbstractStub<Greeter3FutureStub> {
    private Greeter3FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter3FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter3FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter3FutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HELLO_WORLD_CLIENT_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Greeter3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Greeter3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO_WORLD_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.helloWorldClientStream(
              (io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientStreamProto.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Greeter3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Greeter3BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.__gRPCServer.HelloWorldClientStreamProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter3");
    }
  }

  private static final class Greeter3FileDescriptorSupplier
      extends Greeter3BaseDescriptorSupplier {
    Greeter3FileDescriptorSupplier() {}
  }

  private static final class Greeter3MethodDescriptorSupplier
      extends Greeter3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Greeter3MethodDescriptorSupplier(String methodName) {
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
      synchronized (Greeter3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Greeter3FileDescriptorSupplier())
              .addMethod(METHOD_HELLO_WORLD_CLIENT_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
