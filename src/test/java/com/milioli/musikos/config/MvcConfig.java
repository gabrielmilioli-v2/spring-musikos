package com.milioli.musikos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@AutoConfigureMockMvc
public class MvcConfig extends ScanTestConfig {

    public static void main(String... args) {
        SpringApplication.run(MvcConfig.class, args);
    }

}
