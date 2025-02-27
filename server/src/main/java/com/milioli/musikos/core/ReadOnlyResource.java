package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class ReadOnlyResource<T, ID extends java.io.Serializable> {

    @Autowired
    private ReadOnlyService<T, ID> service;

    @GetMapping
    public Page<T> findAll(@RequestParam(name = "search", required = false) String search, Pageable pageable) {
        return service.findAll(search, pageable);
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable("id") ID id) {
        return service.findById(id).orElse(null);
    }

}
