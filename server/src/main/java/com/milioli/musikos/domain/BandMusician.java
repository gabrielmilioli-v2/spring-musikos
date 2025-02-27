package com.milioli.musikos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.milioli.musikos.core.BaseEntity;
import com.milioli.musikos.enums.Instrument;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
@Table(name = "band_musician")
public class BandMusician implements BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_band")
    @JsonIgnoreProperties({"musician.bands"})
    @NotNull
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_musician")
    @JsonIgnoreProperties({"bands"})
    @NotNull
    private Musician musician;

    @Column(name = "id_instrument")
    @NotNull
    private Instrument instrument;

    @Length(max = 255)
    private String about;

}
