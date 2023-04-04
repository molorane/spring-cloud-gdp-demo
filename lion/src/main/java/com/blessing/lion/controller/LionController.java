package com.blessing.lion.controller;

import com.blessing.lion.config.LionConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lion")
public class LionController {

    @GetMapping("vendor")
    public String getVendor(final LionConfig lionConfig) {
        return lionConfig.getVendor();
    }
}