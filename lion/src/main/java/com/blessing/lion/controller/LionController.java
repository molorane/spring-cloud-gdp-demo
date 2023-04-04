package com.blessing.lion.controller;

import com.blessing.lion.config.LionConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lion")
@AllArgsConstructor
public class LionController {

    final LionConfig lionConfig;

    @GetMapping("vendor")
    public String getVendor() {
        return lionConfig.getVendor();
    }
}