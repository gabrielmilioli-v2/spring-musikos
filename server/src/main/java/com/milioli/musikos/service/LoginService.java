package com.milioli.musikos.service;

import com.milioli.musikos.domain.Musician;
import com.milioli.musikos.record.Login;
import com.milioli.musikos.repository.MusicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LoginService {

    private PasswordService passwordService;

    private MusicianRepository musicianRepository;

    public UUID checkPasswordAndReturnId(Login login) {
        final Musician musician = musicianRepository.findByEmail(login.email())
                .orElseThrow(() -> new IllegalStateException("Email not found."));
        if (!passwordService.check(login.password(), musician.getEncodedPassword())) {
            throw new IllegalStateException("Wrong password.");
        }

        return musician.getId();
    }
}
