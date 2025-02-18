package com.milioli.musikos.service;

import com.milioli.musikos.core.CrudService;
import com.milioli.musikos.domain.Musician;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MusicianService extends CrudService<Musician, UUID> {

}
