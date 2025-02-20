package com.milioli.musikos.service;

import com.milioli.musikos.config.GlobalTestConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@GlobalTestConfig
public class PasswordServiceTest {

    @Autowired
    private PasswordService service;

    @Test
    void encode() {

        final String rawPassword = "senha123";
        final String encodedPassword = service.encode(rawPassword);

        Assertions.assertThat(encodedPassword).isNotNull().isNotEmpty();

    }

    @Test
    void check() {

        final String rawPassword = "senha123";
        final String encodedPassword = service.encode(rawPassword);

        Assertions.assertThat(service.check(rawPassword, encodedPassword)).isTrue();

    }

}
