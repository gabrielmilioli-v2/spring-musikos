package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ReadOnlyResource<T, ID extends java.io.Serializable> {

    @Autowired
    private ReadOnlyService<T, ID> service;

    @GetMapping
    public Iterable<T> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable("id") ID id) {
        return service.findById(id).orElse(null);
    }

}
