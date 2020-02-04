package com.example.__gRPCClient;

import com.example.__gRPCClient.grpc.client.HelloWorldClientAndServerStream_Client_4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);

		HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4("127.0.0.1",50054);
		try{
			String user = "world";
			if (args.length > 0){
				user = args[0];
			}
			client.greet(user);
		}finally {
			client.shutdown();
		}
	}


}
