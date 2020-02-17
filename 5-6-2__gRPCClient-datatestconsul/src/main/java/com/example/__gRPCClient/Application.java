package com.example.__gRPCClient;

import com.example.__gRPCClient.grpc.client.HelloWorldClientAndServerStream_Client_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/get-greeting")
	public String greeting() throws InterruptedException {

		List<ServiceInstance> instances = discoveryClient.getInstances("grpc-server");
		for(ServiceInstance serviceInstance : instances){
			String hostName = serviceInstance.getHost();
			int gRpcPort = serviceInstance.getPort() + 1;
			int gRPCA = Integer.valueOf(serviceInstance.getMetadata().get("grpc-portA"));
			System.out.println(hostName+gRPCA);
			HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4(hostName, gRPCA);
			try {
				String user = "world";
				client.greet(user);
			} finally {
//				client.shutdown();
			}
		}
		return "20000";
	}
	@RequestMapping("/loadbalace-greeting")
	public String loadbalaceGreeting() throws InterruptedException, URISyntaxException {
		List<ServiceInstance> instances = discoveryClient.getInstances("grpc-server");
		for(ServiceInstance serviceInstance : instances){
			String hostName = serviceInstance.getHost();
			int gRpcPort = serviceInstance.getPort() + 1;
			int gRPCA = Integer.valueOf(serviceInstance.getMetadata().get("grpc-portA"));
			int gRPCB = Integer.valueOf(serviceInstance.getMetadata().get("grpc-portB"));
			System.out.println("ServiceListPort="+gRPCA+gRPCB);
			HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4(hostName, gRPCA,gRPCB,1);
			long time1 = System.currentTimeMillis();
			try {
				String user = "world";
				client.greet(user);
			} finally {
				client.shutdown();
				long time2 = System.currentTimeMillis();
				System.out.println((time2-time1)/1000.0 + "秒");
			}
		}
		return "20000";
	}
	@RequestMapping("/get")
	public String get() throws InterruptedException {

		List<ServiceInstance> instances = discoveryClient.getInstances("grpc-server");
		for(ServiceInstance serviceInstance : instances){
			String hostName = serviceInstance.getHost();
			int gRPCA = Integer.valueOf(serviceInstance.getMetadata().get("grpc-portA"));
			System.out.println(hostName+gRPCA);
			HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4(hostName, gRPCA);
			long time1 = System.currentTimeMillis();
			try {
				String user = "world";
				client.getGreet(user);
			} finally {
				client.shutdown();
				long time2 = System.currentTimeMillis();
				System.out.println((time2-time1)/1000.0 + "秒");
			}
		}
		return "20000";
	}
}
