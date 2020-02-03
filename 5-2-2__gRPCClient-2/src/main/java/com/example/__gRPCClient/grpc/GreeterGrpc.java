package com.example.__gRPCClient.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 * <pre>
 *定义接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.1)",
    comments = "Source: helloworld.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "helloworld.Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHello",
      requestType = HelloWorldProto.HelloRequest.class,
      responseType = HelloWorldProto.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
          GreeterGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("sayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorld1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloWorld1",
      requestType = HelloWorldProto.HelloRequest.class,
      responseType = HelloWorldProto.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorld1Method() {
    io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply> getHelloWorld1Method;
    if ((getHelloWorld1Method = GreeterGrpc.getHelloWorld1Method) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getHelloWorld1Method = GreeterGrpc.getHelloWorld1Method) == null) {
          GreeterGrpc.getHelloWorld1Method = getHelloWorld1Method =
              io.grpc.MethodDescriptor.<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloWorld1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("HelloWorld1"))
              .build();
        }
      }
    }
    return getHelloWorld1Method;
  }

  private static volatile io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorldServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloWorldServerStream",
      requestType = HelloWorldProto.HelloRequest.class,
      responseType = HelloWorldProto.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorldServerStreamMethod() {
    io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply> getHelloWorldServerStreamMethod;
    if ((getHelloWorldServerStreamMethod = GreeterGrpc.getHelloWorldServerStreamMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getHelloWorldServerStreamMethod = GreeterGrpc.getHelloWorldServerStreamMethod) == null) {
          GreeterGrpc.getHelloWorldServerStreamMethod = getHelloWorldServerStreamMethod =
              io.grpc.MethodDescriptor.<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloWorldServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("HelloWorldServerStream"))
              .build();
        }
      }
    }
    return getHelloWorldServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorldClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloWorldClientStream",
      requestType = HelloWorldProto.HelloRequest.class,
      responseType = HelloWorldProto.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorldClientStreamMethod() {
    io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply> getHelloWorldClientStreamMethod;
    if ((getHelloWorldClientStreamMethod = GreeterGrpc.getHelloWorldClientStreamMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getHelloWorldClientStreamMethod = GreeterGrpc.getHelloWorldClientStreamMethod) == null) {
          GreeterGrpc.getHelloWorldClientStreamMethod = getHelloWorldClientStreamMethod =
              io.grpc.MethodDescriptor.<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloWorldClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("HelloWorldClientStream"))
              .build();
        }
      }
    }
    return getHelloWorldClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorldClientAndServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloWorldClientAndServerStream",
      requestType = HelloWorldProto.HelloRequest.class,
      responseType = HelloWorldProto.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest,
      HelloWorldProto.HelloReply> getHelloWorldClientAndServerStreamMethod() {
    io.grpc.MethodDescriptor<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply> getHelloWorldClientAndServerStreamMethod;
    if ((getHelloWorldClientAndServerStreamMethod = GreeterGrpc.getHelloWorldClientAndServerStreamMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getHelloWorldClientAndServerStreamMethod = GreeterGrpc.getHelloWorldClientAndServerStreamMethod) == null) {
          GreeterGrpc.getHelloWorldClientAndServerStreamMethod = getHelloWorldClientAndServerStreamMethod =
              io.grpc.MethodDescriptor.<HelloWorldProto.HelloRequest, HelloWorldProto.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloWorldClientAndServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloWorldProto.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("HelloWorldClientAndServerStream"))
              .build();
        }
      }
    }
    return getHelloWorldClientAndServerStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    return new GreeterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreeterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreeterFutureStub(channel);
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(HelloWorldProto.HelloRequest request,
                         io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     *一个简单的rpc
     * </pre>
     */
    public void helloWorld1(HelloWorldProto.HelloRequest request,
                            io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloWorld1Method(), responseObserver);
    }

    /**
     * <pre>
     *一个服务器端流式rpc
     * </pre>
     */
    public void helloWorldServerStream(HelloWorldProto.HelloRequest request,
                                       io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloWorldServerStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *一个客户端流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloWorldProto.HelloRequest> helloWorldClientStream(
        io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getHelloWorldClientStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *一个客户端和服务器端双向流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloWorldProto.HelloRequest> helloWorldClientAndServerStream(
        io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getHelloWorldClientAndServerStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                HelloWorldProto.HelloRequest,
                HelloWorldProto.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getHelloWorld1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                HelloWorldProto.HelloRequest,
                HelloWorldProto.HelloReply>(
                  this, METHODID_HELLO_WORLD1)))
          .addMethod(
            getHelloWorldServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                HelloWorldProto.HelloRequest,
                HelloWorldProto.HelloReply>(
                  this, METHODID_HELLO_WORLD_SERVER_STREAM)))
          .addMethod(
            getHelloWorldClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                HelloWorldProto.HelloRequest,
                HelloWorldProto.HelloReply>(
                  this, METHODID_HELLO_WORLD_CLIENT_STREAM)))
          .addMethod(
            getHelloWorldClientAndServerStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                HelloWorldProto.HelloRequest,
                HelloWorldProto.HelloReply>(
                  this, METHODID_HELLO_WORLD_CLIENT_AND_SERVER_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractStub<GreeterStub> {
    private GreeterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GreeterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(HelloWorldProto.HelloRequest request,
                         io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *一个简单的rpc
     * </pre>
     */
    public void helloWorld1(HelloWorldProto.HelloRequest request,
                            io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloWorld1Method(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *一个服务器端流式rpc
     * </pre>
     */
    public void helloWorldServerStream(HelloWorldProto.HelloRequest request,
                                       io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getHelloWorldServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *一个客户端流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloWorldProto.HelloRequest> helloWorldClientStream(
        io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getHelloWorldClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *一个客户端和服务器端双向流式rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<HelloWorldProto.HelloRequest> helloWorldClientAndServerStream(
        io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getHelloWorldClientAndServerStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractStub<GreeterBlockingStub> {
    private GreeterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GreeterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     */
    public HelloWorldProto.HelloReply sayHello(HelloWorldProto.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *一个简单的rpc
     * </pre>
     */
    public HelloWorldProto.HelloReply helloWorld1(HelloWorldProto.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getHelloWorld1Method(), getCallOptions(), request);
    }

    /**
     * <pre>
     *一个服务器端流式rpc
     * </pre>
     */
    public java.util.Iterator<HelloWorldProto.HelloReply> helloWorldServerStream(
        HelloWorldProto.HelloRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getHelloWorldServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义接口
   * </pre>
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractStub<GreeterFutureStub> {
    private GreeterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GreeterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloWorldProto.HelloReply> sayHello(
        HelloWorldProto.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *一个简单的rpc
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloWorldProto.HelloReply> helloWorld1(
        HelloWorldProto.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloWorld1Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_HELLO_WORLD1 = 1;
  private static final int METHODID_HELLO_WORLD_SERVER_STREAM = 2;
  private static final int METHODID_HELLO_WORLD_CLIENT_STREAM = 3;
  private static final int METHODID_HELLO_WORLD_CLIENT_AND_SERVER_STREAM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((HelloWorldProto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply>) responseObserver);
          break;
        case METHODID_HELLO_WORLD1:
          serviceImpl.helloWorld1((HelloWorldProto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply>) responseObserver);
          break;
        case METHODID_HELLO_WORLD_SERVER_STREAM:
          serviceImpl.helloWorldServerStream((HelloWorldProto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply>) responseObserver);
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
        case METHODID_HELLO_WORLD_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.helloWorldClientStream(
              (io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply>) responseObserver);
        case METHODID_HELLO_WORLD_CLIENT_AND_SERVER_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.helloWorldClientAndServerStream(
              (io.grpc.stub.StreamObserver<HelloWorldProto.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return HelloWorldProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getHelloWorld1Method())
              .addMethod(getHelloWorldServerStreamMethod())
              .addMethod(getHelloWorldClientStreamMethod())
              .addMethod(getHelloWorldClientAndServerStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
