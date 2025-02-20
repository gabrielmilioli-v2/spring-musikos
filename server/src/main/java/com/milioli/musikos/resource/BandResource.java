package com.milioli.musikos.resource;

import com.milioli.musikos.core.CrudResource;
import com.milioli.musikos.domain.Band;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/bands")
public class BandResource extends CrudResource<Band, UUID> {
}
