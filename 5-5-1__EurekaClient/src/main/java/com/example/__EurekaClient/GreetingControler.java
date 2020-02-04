package com.example.__EurekaClient;

import org.springframework.web.bind.annotation.PostMapping;

public interface GreetingControler {
    @PostMapping(value = "/greeting")
    String greeting();

}
