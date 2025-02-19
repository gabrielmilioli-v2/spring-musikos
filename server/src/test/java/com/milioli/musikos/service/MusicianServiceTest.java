package com.milioli.musikos.service;

import com.milioli.musikos.config.GlobalTestConfig;
import com.milioli.musikos.domain.Musician;
import com.milioli.musikos.enums.Instrument;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

@GlobalTestConfig
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

    @Test
    void save() {

        final Musician musician = new Musician();
        musician.setFirstName("Gabriel");
        musician.setLastName("Milioli");
        musician.setEncodedPassword("senha123");
        musician.setEmail("gabriel@milioli.com");
        musician.setInstrument(Instrument.BAIXO);

        final Musician musicianCreated = service.save(musician);
        Assertions.assertThat(musicianCreated).isNotNull();
        Assertions.assertThat(musicianCreated.getId()).isNotNull();
    }

}
