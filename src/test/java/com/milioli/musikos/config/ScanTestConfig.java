package com.milioli.musikos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({"com.milioli.*"})
@EntityScan({"com.milioli.*"})
@ComponentScan({"com.milioli.*"})
public class ScanTestConfig {

    public static void main(String... args) {
        SpringApplication.run(ScanTestConfig.class, args);
    }

}
