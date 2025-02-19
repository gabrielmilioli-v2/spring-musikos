package com.milioli.musikos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.milioli.musikos.core.BaseEntity;
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
public class Band implements BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    @Length(max = 50)
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_musician")
    @JsonIgnoreProperties({"bands"})
    @NotNull
    private Musician createdBy;

    @Length(max = 2000)
    private String description;

    @Length(max = 100)
    private String instagram;

    @OneToMany(mappedBy = "band")
    @JsonIgnoreProperties({"band", "musician.bands"})
    private final Set<BandMusician> musicians = new HashSet<>();

}
