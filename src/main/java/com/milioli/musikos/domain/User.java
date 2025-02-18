package com.milioli.musikos.domain;

import com.milioli.musikos.enums.Instrument;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    @Length(max = 50)
    private String name;

    @Column(name = "last_name")
    @Length(max = 100)
    private String lastName;

    @Column
    @Length(max = 100)
    private String password;

    @Column(name = "id_instrument")
    private Instrument instrument;

}
