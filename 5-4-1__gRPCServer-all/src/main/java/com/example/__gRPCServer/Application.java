package com.example.__gRPCServer;

import com.example.__gRPCServer.grpc.server.HelloWorldClientAndServerStream_Server_4;
import com.example.__gRPCServer.grpc.server.SayHello_Server_0;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Application.class, args);
		final SayHello_Server_0 server = new SayHello_Server_0();
		server.start(50051);


		final SayHello_Server_0 server1 = new SayHello_Server_0();
		server1.start(50052);


		final SayHello_Server_0 server2 = new SayHello_Server_0();
		server2.start(50053);
		server.blockUntilShutdown();
		server1.blockUntilShutdown();
		server2.blockUntilShutdown();
//		final HelloWorldClientAndServerStream_Server_4 server = new HelloWorldClientAndServerStream_Server_4();
//		server.start();
//		server.blockUntilShutdown();

		//____________________________________________________________//
//		System.out.println("===== 构建一个GPS模型开始 =====");
//		GpsDataProto.gps_data.Builder gps_builder = GpsDataProto.gps_data.newBuilder();
//		gps_builder.setAltitude(1);
//		gps_builder.setDataTime("2017-12-17 16:21:44");
//		gps_builder.setGpsStatus(1);
//		gps_builder.setLat(39.123);
//		gps_builder.setLon(120.112);
//		gps_builder.setDirection(30.2F);
//		gps_builder.setId(100L);
//
//		GpsDataProto.gps_data gps_data = gps_builder.build();
//		System.out.println(gps_data.toString());
//		System.out.println("===== 构建GPS模型结束 =====");
//
//		System.out.println("===== gps Byte 开始=====");
//		for (byte b : gps_data.toByteArray()) {
//			System.out.print(b);
//		}
//		System.out.println("\n" + "bytes长度" + gps_data.toByteString().size());
//		System.out.println("===== gps Byte 结束 =====");
//
//		System.out.println("===== 使用gps 反序列化生成对象开始 =====");
//		GpsDataProto.gps_data gd = null;
//		try {
//			gd = GpsDataProto.gps_data.parseFrom(gps_data.toByteArray());
//		} catch (InvalidProtocolBufferException e) {
//			e.printStackTrace();
//		}
//		System.out.print(gd.toString());
//		System.out.println("===== 使用gps 反序列化生成对象结束 =====");
	}

}
