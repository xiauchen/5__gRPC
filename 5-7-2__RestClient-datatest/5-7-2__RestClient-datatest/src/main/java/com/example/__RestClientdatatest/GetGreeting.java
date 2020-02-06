package com.example.__RestClientdatatest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("restful-server")
public interface GetGreeting {
    @RequestMapping("/get?world=world")
    String greeting();
}