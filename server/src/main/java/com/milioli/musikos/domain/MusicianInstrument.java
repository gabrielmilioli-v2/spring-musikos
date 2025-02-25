package com.milioli.musikos.domain;

import com.milioli.musikos.core.BaseEntity;
import com.milioli.musikos.enums.Instrument;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.type.YesNoConverter;

import java.util.UUID;

@Entity
@Data
@Table(name = "musician_instrument")
public class MusicianInstrument implements BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_musician")
    private Musician musician;

    @Column(name = "id_instrument")
    @NotNull
    private Instrument instrument;

    @Convert(converter = YesNoConverter.class)
    @NotNull
    private Boolean main;

}
