package com.milioli.musikos.core;

import io.github.perplexhub.rsql.RSQLJPASupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;
import java.util.Optional;

public class ReadOnlyService<T, ID extends java.io.Serializable> {

    @Autowired
    private ReadOnlyRepository<T, ID> repository;

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(String search, Pageable pageable) {
        if (Objects.isNull(search)) {
            return repository.findAll(pageable);
        }
        final Specification<T> specification = RSQLJPASupport.toSpecification(search);
        return repository.findAll(specification, pageable);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

}
