package com.milioli.musikos.service;

import com.milioli.musikos.core.CrudService;
import com.milioli.musikos.domain.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class MusicianService extends CrudService<Musician, UUID> {

    @Autowired
    private PasswordService passwordService;

    @Override
    public void beforeSave(final Musician entity) {
        if (Objects.nonNull(entity.getPassword())) {
            entity.setEncodedPassword(passwordService.encode(entity.getPassword()));
        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordService.check(rawPassword, encodedPassword);
    }

}
