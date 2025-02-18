package com.milioli.musikos.service;

import com.milioli.musikos.config.PersistenceTestConfig;
import com.milioli.musikos.domain.Musician;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceTestConfig.class)
public class MusicianServiceTest {

    @Autowired
    private MusicianService service;

    @Test
    void findAll() {
        final Iterable<Musician> musicians = service.findAll();
        Assertions.assertThat(musicians).isNotEmpty();
    }

    @Test
    void findById() {
        final Optional<Musician> musician = service.findById(UUID.fromString("cf980cb7-208c-4d82-860f-fb1bd575f673"));
        Assertions.assertThat(musician).isPresent();
    }

}
