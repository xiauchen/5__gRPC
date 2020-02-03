package com.example.__gRPCClient.grpc.java;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *定义接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.1)",
    comments = "Source: helloworld.proto")
public final class Greeter1Grpc {

  private Greeter1Grpc() {}

  public static final String SERVICE_NAME = "helloworld.Greeter1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.__gRPCServer.HelloWorldProto.HelloRequest,
      com.example.__gRPCServer.HelloWorldProto.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHello",
      requestType = com.example.__gRPCServer.HelloWorldProto.HelloRequest.class,
      responseType = com.example.__gRPCServer.HelloWorldProto.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.__gRPCServer.HelloWorldProto.HelloRequest,
      com.example.__gRPCServer.HelloWorldProto.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.example.__gRPCServer.HelloWorldProto.HelloRequest, com.example.__gRPCServer.HelloWorldProto.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = Greeter1Grpc.getSayHelloMethod) == null) {
      synchronized (Greeter1Grpc.class) {
        if ((getSayHelloMethod = Greeter1Grpc.getSayHelloMethod) == null) {
          Greeter1Grpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<com.example.__gRPCServer.HelloWorldProto.HelloRequest, com.example.__gRPCServer.HelloWorldProto.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.__gRPCServer.HelloWorldProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.__gRPCServer.HelloWorldProto.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new Greeter1MethodDescriptorSupplier("sayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Greeter1Stub newStub(io.grpc.Channel channel) {
    return new Greeter1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Greeter1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Greeter1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Greeter1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Greeter1FutureStub(channel);
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static abstract class Greeter1ImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.example.__gRPCServer.HelloWorldProto.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldProto.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.__gRPCServer.HelloWorldProto.HelloRequest,
                com.example.__gRPCServer.HelloWorldProto.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter1Stub extends io.grpc.stub.AbstractStub<Greeter1Stub> {
    private Greeter1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter1Stub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.example.__gRPCServer.HelloWorldProto.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldProto.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter1BlockingStub extends io.grpc.stub.AbstractStub<Greeter1BlockingStub> {
    private Greeter1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter1BlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.__gRPCServer.HelloWorldProto.HelloReply sayHello(com.example.__gRPCServer.HelloWorldProto.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class Greeter1FutureStub extends io.grpc.stub.AbstractStub<Greeter1FutureStub> {
    private Greeter1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Greeter1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Greeter1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Greeter1FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.__gRPCServer.HelloWorldProto.HelloReply> sayHello(
        com.example.__gRPCServer.HelloWorldProto.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Greeter1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Greeter1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.example.__gRPCServer.HelloWorldProto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.example.__gRPCServer.HelloWorldProto.HelloReply>) responseObserver);
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

  private static abstract class Greeter1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Greeter1BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.__gRPCServer.HelloWorldProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter1");
    }
  }

  private static final class Greeter1FileDescriptorSupplier
      extends Greeter1BaseDescriptorSupplier {
    Greeter1FileDescriptorSupplier() {}
  }

  private static final class Greeter1MethodDescriptorSupplier
      extends Greeter1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Greeter1MethodDescriptorSupplier(String methodName) {
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
      synchronized (Greeter1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Greeter1FileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
