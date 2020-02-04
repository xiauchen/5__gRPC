package com.example.__EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Application implements GreetingControler{
	@Autowired
	@Lazy
	private DiscoveryClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public String greeting(){
		return "Hello from consul";
//				String.format(
//				"Hello from Consul %s",;
//				"Hello from '%s'-1 !",eurekaClient.getServices().get(appName).getName());
	}
}
