package com.milioli.musikos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
@Table
public class Admin {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    @Length(max = 100)
    @NotNull
    private String email;

    @Column(name = "encoded_password")
    @Length(max = 100)
    @NotNull
    private String encodedPassword;

}
