package com.milioli.musikos.repository;

import com.milioli.musikos.core.CrudRepository;
import com.milioli.musikos.domain.Band;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BandRepository extends CrudRepository<Band, UUID> {
}
