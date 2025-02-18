package com.milioli.musikos.repository;

import com.milioli.musikos.config.PersistenceTestConfig;
import com.milioli.musikos.domain.Musician;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceTestConfig.class)
public class MusicianRepositoryTest {

    @Autowired
    private MusicianRepository repository;

    @Test
    void findAll() {
        final List<Musician> musicians = repository.findAll();
        Assertions.assertThat(musicians).isNotEmpty();
    }

}
