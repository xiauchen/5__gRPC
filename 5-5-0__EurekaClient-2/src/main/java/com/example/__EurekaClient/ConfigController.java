package com.example.__EurekaClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
@Configuration
@EnableAutoConfiguration
public class ConfigController {
    @Value("${foo}")
    String foo;

    @Value("${bar}")
    String bar;

    @RequestMapping(value = "/foo")
    public String foo(){
        return foo + "——" + bar;
    }
}
