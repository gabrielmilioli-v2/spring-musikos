package com.milioli.musikos.converter;

import com.milioli.musikos.enums.PosicaoBanda;
import com.milioli.musikos.utils.PersistableEnumConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PosicaoBandaConverter extends PersistableEnumConverter<PosicaoBanda, Long> {

    public PosicaoBandaConverter() {
        super(PosicaoBanda.class);
    }

}
