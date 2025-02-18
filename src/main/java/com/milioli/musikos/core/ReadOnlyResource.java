package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ReadOnlyResource<T, S extends java.io.Serializable> {

    @Autowired
    private ReadOnlyService<T, S> service;

    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable("id") S id) {
        return service.findById(id).orElse(null);
    }

}
