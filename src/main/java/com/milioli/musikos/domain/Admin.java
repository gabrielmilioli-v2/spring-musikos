package com.milioli.musikos.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table
public class Admin {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

}
