package com.milioli.musikos.repository;

import com.milioli.musikos.core.ReadOnlyRepository;
import com.milioli.musikos.domain.Musician;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MusicianRepository extends ReadOnlyRepository<Musician, UUID> {
}
