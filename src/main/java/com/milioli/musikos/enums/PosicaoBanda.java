package com.milioli.musikos.enums;

import com.milioli.musikos.utils.PersistableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PosicaoBanda implements PersistableEnum<Long> {

    OUTRO(1L, "Outro"),
    GUITARRA(2L, "Guitarra"),
    BAIXO(3L, "Baixo"),
    BATERIA(4L, "Bateria"),
    VOCAL(5L, "Vocal");

    private final Long id;
    private final String descricao;

}
