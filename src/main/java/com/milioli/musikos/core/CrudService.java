package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CrudService<T, ID extends java.io.Serializable> extends ReadOnlyService<T, ID> {

    @Autowired
    private CrudRepository<T, ID> repository;

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public Iterable<T> saveAll(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public void deleteAll(Iterable<T> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
