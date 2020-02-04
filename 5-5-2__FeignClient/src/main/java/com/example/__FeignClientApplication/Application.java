package com.example.__FeignClientApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Controller
@EnableDiscoveryClient
public class Application {
	@Autowired
	private GreetingClient greetingClient;
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/get-greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting",greetingClient.greeting());
		return "greeting-view";
	}
	@RequestMapping("getOrder")
	public String getOrder(){

		List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
		String a = null;
		for(ServiceInstance s:instances){
			a = s.getUri().toString();
		}

		//一种直接写访问路径,另一种是写服务名称
		//使用名称形式的话需要在RestTemplate上加@LoadBalanced开启ribbon负载均衡器
		//String forObject = restTemplate.getForObject("http://consul-member/getMember", String.class);
		//String forObject = restTemplate.getForObject("http://192.168.244.1:8000/getMember", String.class); 一般不直接写地址
//		String forObject = restTemplate.getForObject("http://127.0.0.1:8300/eureka-client", String.class);
		return "asdsa";
	}
}