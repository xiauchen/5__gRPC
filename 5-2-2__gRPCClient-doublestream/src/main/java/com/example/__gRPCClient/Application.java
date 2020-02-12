package com.example.__gRPCClient;

import com.example.__gRPCClient.grpc.client.HelloWorldClientAndServerStream_Client_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
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
			HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4(hostName, gRpcPort);
			try {
				String user = "world";
				client.greet(user);
			} finally {
				client.shutdown();
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
			HelloWorldClientAndServerStream_Client_4 client = new HelloWorldClientAndServerStream_Client_4(hostName, gRpcPort-1,1);
			try {
				String user = "world";
				client.greet(user);
			} finally {
				client.shutdown();
			}
		}
		return "20000";
	}
}
