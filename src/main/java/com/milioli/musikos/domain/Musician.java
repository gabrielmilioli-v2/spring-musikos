package com.milioli.musikos.domain;

import com.milioli.musikos.core.BaseEntity;
import com.milioli.musikos.enums.Instrument;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table
public class Musician implements BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    @Length(max = 50)
    @NotNull
    private String name;

    @Column(name = "last_name")
    @Length(max = 100)
    @NotNull
    private String lastName;

    @Column
    @Length(max = 100)
    @NotNull
    private String password;

    @Column(name = "id_instrument")
    @NotNull
    private Instrument instrument;

    @Length(max = 2000)
    private String description;

    @Length(max = 100)
    private String instagram;

    @Length(max = 20)
    private String phone;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Band> bands = new HashSet<>();

}
