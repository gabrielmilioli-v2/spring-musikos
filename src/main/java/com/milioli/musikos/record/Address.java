package com.milioli.musikos.record;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Address(@Column String postcode,
                      @Column String street,
                      @Column String neighborhood,
                      @Column String city,
                      @Column String state) {
}