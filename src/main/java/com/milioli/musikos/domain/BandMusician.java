package com.milioli.musikos.domain;

import com.milioli.musikos.enums.Instrument;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
@Table(name = "band_musician")
public class BandMusician {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_band")
    @NotNull
    private Band band;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_musician")
    @NotNull
    private Musician musician;

    @Column(name = "id_instrument")
    @NotNull
    private Instrument instrument;

    @Length(max = 255)
    private String description;

}
