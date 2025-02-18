package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReadOnlyService<T, S extends java.io.Serializable> {

    @Autowired
    private ReadOnlyRepository<T, S> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(S id) {
        return repository.findById(id);
    }

}
