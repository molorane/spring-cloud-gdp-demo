package com.blessing.rhino.controller;

import com.blessing.rhino.config.RhinoProps;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class RhinoController {

    final RhinoProps rhinoProps;
    private RestTemplate restTemplate;

    @GetMapping("vendor")
    public String getVendor() {
        return rhinoProps.getVendor();
    }

    @GetMapping("lion")
    @CircuitBreaker(name = "lionService", fallbackMethod = "fallback")
    public String callLion() {
        return restTemplate.getForEntity("http://lion/vendor", String.class).getBody();
    }

    public String fallback(Exception e) {
        return "Service not reachable";
    }
}