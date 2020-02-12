package com.example.__FeignClientApplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "eureka-client")
public interface GreetingClient {
    @PostMapping("/greeting")
    String greeting();
}