package com.milioli.musikos.resource;

import com.milioli.musikos.dto.AddressDto;
import com.milioli.musikos.record.Address;
import com.milioli.musikos.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("addresses")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping("/{cep}")
    public Address findByCep(@PathVariable("cep") String cep) {
        return service.findByCep(cep);
    }

    @GetMapping
    public Set<AddressDto> findAll() {
        return service.findAll();
    }

}
