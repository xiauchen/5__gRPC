package com.example.__gRPCServer.grpc.greeter;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *定义接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: helloworldClientAndServerStream.proto")
public final class Greeter4Grpc {

  private Greeter4Grpc() {}

  public static final String SERVICE_NAME = "helloworldclientandserverstream.Greeter4";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloRequest,
      com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply> METHOD_HELLO_WORLD_CLIENT_AND_SERVER_STREAM =
      io.grpc.MethodDescriptor.<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloRequest, com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "helloworldclientandserverstream.Greeter4", "HelloWorldClientAndServerStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply.getDefaultInstance()))
          .setSchemaDescriptor(new Greeter4MethodDescriptorSupplier("HelloWorldClientAndServerStream"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Greeter4Stub newStub(io.grpc.Channel channel) {
    return new Greeter4Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Greeter4BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Greeter4BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Greeter4FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Greeter4FutureStub(channel);
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static abstract class Greeter4ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *一个客户端和服务器端双向流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloRequest> helloWorldClientAndServerStream(
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_HELLO_WORLD_CLIENT_AND_SERVER_STREAM, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_HELLO_WORLD_CLIENT_AND_SERVER_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloRequest,
                com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply>(
                  this, METHODID_HELLO_WORLD_CLIENT_AND_SERVER_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter4Stub extends io.grpc.stub.AbstractStub<Greeter4Stub> {
    private Greeter4Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter4Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter4Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter4Stub(channel, callOptions);
    }

    /**
     * <pre>
     *一个客户端和服务器端双向流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloRequest> helloWorldClientAndServerStream(
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_HELLO_WORLD_CLIENT_AND_SERVER_STREAM, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter4BlockingStub extends io.grpc.stub.AbstractStub<Greeter4BlockingStub> {
    private Greeter4BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter4BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter4BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter4BlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter4FutureStub extends io.grpc.stub.AbstractStub<Greeter4FutureStub> {
    private Greeter4FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter4FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter4FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter4FutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HELLO_WORLD_CLIENT_AND_SERVER_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Greeter4ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Greeter4ImplBase serviceImpl, int methodId) {
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
        case METHODID_HELLO_WORLD_CLIENT_AND_SERVER_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.helloWorldClientAndServerStream(
              (io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Greeter4BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Greeter4BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.__gRPCServer.HelloWorldClientAndServerStreamProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter4");
    }
  }

  private static final class Greeter4FileDescriptorSupplier
      extends Greeter4BaseDescriptorSupplier {
    Greeter4FileDescriptorSupplier() {}
  }

  private static final class Greeter4MethodDescriptorSupplier
      extends Greeter4BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Greeter4MethodDescriptorSupplier(String methodName) {
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
      synchronized (Greeter4Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Greeter4FileDescriptorSupplier())
              .addMethod(METHOD_HELLO_WORLD_CLIENT_AND_SERVER_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
