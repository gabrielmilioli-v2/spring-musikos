package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReadOnlyService<T, ID extends java.io.Serializable> {

    @Autowired
    private ReadOnlyRepository<T, ID> repository;

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

}
