package com.milioli.musikos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.milioli.musikos.core.BaseEntity;
import com.milioli.musikos.record.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
public class Musician implements BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column(name = "first_name")
    @Length(max = 50)
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @Length(max = 100)
    @NotNull
    private String lastName;

    @Column
    @Length(max = 100)
    @NotNull
    private String email;

    @Column(name = "encoded_password")
    @Length(max = 100)
    @JsonIgnore
    private String encodedPassword;

    @Length(max = 2000)
    private String description;

    @Length(max = 100)
    private String instagram;

    @Length(max = 20)
    private String phone;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Band> bands = new ArrayList<>();

    @OneToMany(mappedBy = "musician", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<MusicianInstrument> instruments = new ArrayList<>();

    @Embedded
    private Address address;

    @Transient
    private String password;

}
