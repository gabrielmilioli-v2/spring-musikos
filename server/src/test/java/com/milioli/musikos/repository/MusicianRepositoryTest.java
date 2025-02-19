package com.milioli.musikos.repository;

import com.milioli.musikos.config.GlobalTestConfig;
import com.milioli.musikos.domain.Musician;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

@GlobalTestConfig
public class MusicianRepositoryTest {

    @Autowired
    private MusicianRepository repository;

    @Test
    void findAll() {
        final Iterable<Musician> musicians = repository.findAll();
        Assertions.assertThat(musicians).isNotEmpty();
    }

    @Test
    void findAllPageable() {
        final Page<Musician> musicians = repository.findAll(Pageable.ofSize(1));
        Assertions.assertThat(musicians).isNotEmpty();
    }

    @Test
    void findById() {
        final Optional<Musician> musician = repository.findById(UUID.fromString("cf980cb7-208c-4d82-860f-fb1bd575f673"));
        Assertions.assertThat(musician).isPresent();
    }

}
