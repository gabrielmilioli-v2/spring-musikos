package com.milioli.musikos.resource;

import com.milioli.musikos.core.CrudResource;
import com.milioli.musikos.domain.Musician;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("musicians")
public class MusicianResource extends CrudResource<Musician, UUID> {

}
