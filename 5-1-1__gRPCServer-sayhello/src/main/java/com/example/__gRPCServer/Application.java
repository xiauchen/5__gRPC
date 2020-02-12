package com.example.__gRPCServer;

import com.google.protobuf.InvalidProtocolBufferException;
//import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
//	@Bean
//	public GreeterService greeterService() {
//		return new GreeterService();
//	}

//	@GRpcService(interceptors = NotSpringBeanInterceptor.class)
//	public static class CalculatorService extends CalculatorGrpc.CalculatorImplBase{
//		@Override
//		public void calculate(CalculatorOuterClass.CalculatorRequest request, StreamObserver<CalculatorOuterClass.CalculatorResponse> responseObserver) {
//			CalculatorOuterClass.CalculatorResponse.Builder resultBuilder = CalculatorOuterClass.CalculatorResponse.newBuilder();
//			switch (request.getOperation()){
//				case ADD:
//					resultBuilder.setResult(request.getNumber1()+request.getNumber2());
//					break;
//				case SUBTRACT:
//					resultBuilder.setResult(request.getNumber1()-request.getNumber2());
//					break;
//				case MULTIPLY:
//					resultBuilder.setResult(request.getNumber1()*request.getNumber2());
//					break;
//				case DIVIDE:
//					resultBuilder.setResult(request.getNumber1()/request.getNumber2());
//					break;
//				case UNRECOGNIZED:
//					break;
//			}
//			responseObserver.onNext(resultBuilder.build());
//			responseObserver.onCompleted();
//		}
//	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
