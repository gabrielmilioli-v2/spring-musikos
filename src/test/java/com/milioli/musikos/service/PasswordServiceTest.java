package com.milioli.musikos.service;

import com.milioli.musikos.config.ScanTestConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ScanTestConfig.class)
public class PasswordServiceTest {

    @Autowired
    private PasswordService service;

    @Test
    void encode() throws Exception {

        final String rawPassword = "senha123";
        final String encodedPassword = service.encode(rawPassword);

        Assertions.assertThat(encodedPassword).isNotNull().isNotEmpty();

    }

    @Test
    void check() throws Exception {

        final String rawPassword = "senha123";
        final String encodedPassword = service.encode(rawPassword);

        Assertions.assertThat(service.check(rawPassword, encodedPassword)).isTrue();

    }

}
