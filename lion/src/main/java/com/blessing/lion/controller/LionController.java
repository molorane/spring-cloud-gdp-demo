package com.blessing.lion.controller;

import com.blessing.lion.config.LionProps;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class LionController {

    final LionProps lionProps;
    private RestTemplate restTemplate;

    @GetMapping("vendor")
    public String getVendor() {
        return lionProps.getVendor();
    }

    @GetMapping("rhino")
    @CircuitBreaker(name = "rhinoService", fallbackMethod = "fallback")
    public String callRhino() {
        return  restTemplate.getForEntity("http://rhino/vendor", String.class).getBody();
    }

    public String fallback(Exception e) {
        return "Service not reachable";
    }
}