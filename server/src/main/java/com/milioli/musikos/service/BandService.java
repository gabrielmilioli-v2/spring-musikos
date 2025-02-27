package com.milioli.musikos.service;

import com.milioli.musikos.core.CrudService;
import com.milioli.musikos.domain.Band;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BandService extends CrudService<Band, UUID> {

}
