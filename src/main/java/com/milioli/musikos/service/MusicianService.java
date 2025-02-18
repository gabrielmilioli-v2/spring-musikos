package com.milioli.musikos.service;

import com.milioli.musikos.core.ReadOnlyService;
import com.milioli.musikos.domain.Musician;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MusicianService extends ReadOnlyService<Musician, UUID> {

}
