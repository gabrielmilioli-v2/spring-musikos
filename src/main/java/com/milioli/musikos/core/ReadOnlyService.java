package com.milioli.musikos.core;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReadOnlyService<T, S extends java.io.Serializable> {

    @Autowired
    private ReadOnlyRepository<T, S> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

}
