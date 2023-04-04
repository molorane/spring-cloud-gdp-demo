package com.blessing.rhino.controller;

import com.blessing.rhino.config.RhinoConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rhino")
@AllArgsConstructor
public class RhinoController {

    final RhinoConfig rhinoConfig;

    @GetMapping("vendor")
    public String getVendor() {
        return rhinoConfig.getVendor();
    }
}