package com.milioli.musikos.core;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CrudRepository<T, ID extends Serializable> extends ReadOnlyRepository<T, ID> {

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);

    void delete(T entity);

    void deleteAll(Iterable<T> entities);

    void deleteAll();

    void deleteById(ID id);

}