package com.milioli.musikos.resource;

import com.milioli.musikos.enums.Instrument;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/instruments")
public class InstrumentResource {

    @GetMapping
    public Instrument[] findAll() {
        return Instrument.values();
    }

}
