package com.blessing.rhino.controller;

import com.blessing.rhino.config.RhinoConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lion")
public class RhinoController {

    @GetMapping("vendor")
    public String getVendor(final RhinoConfig rhinoConfig) {
        return rhinoConfig.getVendor();
    }
}