package com.milioli.musikos.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CrudResource<T extends BaseEntity<ID>, ID extends java.io.Serializable> extends ReadOnlyResource<T, ID> {

    @Autowired
    private CrudService<T, ID> service;

    @PostMapping
    public T create(@RequestBody T body) {
        return service.save(body);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable("id") ID id, @RequestBody T body) {
        return service.findById(id).map(entity -> {
            body.setId(entity.getId());
            return service.save(body);
        }).orElseThrow(IllegalStateException::new);
    }

}
