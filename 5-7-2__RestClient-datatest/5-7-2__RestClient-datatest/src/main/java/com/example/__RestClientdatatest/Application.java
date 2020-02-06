package com.example.__RestClientdatatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
	@Autowired
	private GetGreeting getGreeting;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/get-greeting")
	public String greeting(Model model) {
		long time1 = System.currentTimeMillis();
		model.addAttribute("greeting",getGreeting.greeting());
		model.addAttribute("greeting",getGreeting.greeting());
		model.addAttribute("greeting",getGreeting.greeting());
		long time2 = System.currentTimeMillis();
		System.out.println((time2-time1)/1000.0 + "秒");
		return "greeting-view";
	}

}
