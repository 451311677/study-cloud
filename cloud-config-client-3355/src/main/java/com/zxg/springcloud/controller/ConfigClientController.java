package com.zxg.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaogang.zhang
 * @date 2021/3/11
 * @description
 */
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String getConfigInfo() {
        System.out.println(configInfo);
        return configInfo;
    }
}
