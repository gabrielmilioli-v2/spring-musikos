package com.milioli.musikos.repository;

import com.milioli.musikos.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<User, UUID> {
}
