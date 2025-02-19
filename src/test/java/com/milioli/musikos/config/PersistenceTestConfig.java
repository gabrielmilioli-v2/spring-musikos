package com.milioli.musikos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PersistenceTestConfig extends ScanTestConfig {

    public static void main(String... args) {
        SpringApplication.run(PersistenceTestConfig.class, args);
    }

}
