package com.milioli.musikos.domain;

import com.milioli.musikos.enums.PosicaoBanda;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    @Length(max = 50)
    private String nome;

    @Column
    @Length(max = 100)
    private String sobrenome;

    @Column(name = "id_posicao_banda")
    private PosicaoBanda posicaoBanda;

}
