package com.milioli.musikos.repository;

import com.milioli.musikos.config.PersistenceTestConfig;
import com.milioli.musikos.domain.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceTestConfig.class)
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository repository;

    @Test
    void findAll() {
        final List<Pessoa> pessoas = repository.findAll();
        Assertions.assertThat(pessoas).isNotEmpty();
    }

}
