package com.milioli.musikos.core;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    Optional<T> findById(ID id);

    Iterable<T> findAll();

}