package com.milioli.musikos.converter;

import com.milioli.musikos.enums.PosicaoBanda;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosicaoBandaConverterTest {

    @Test
    void convertToDatabaseColumn() {
        final PosicaoBandaConverter converter = new PosicaoBandaConverter();
        final Long id = converter.convertToDatabaseColumn(PosicaoBanda.BAIXO);
        Assertions.assertThat(id)
                .isNotNull()
                .isEqualTo(PosicaoBanda.BAIXO.getId());
    }

    @Test
    void convertToEntityAttribute() {
        final PosicaoBandaConverter converter = new PosicaoBandaConverter();
        final PosicaoBanda posicaoBanda = converter.convertToEntityAttribute(3L);
        Assertions.assertThat(posicaoBanda)
                .isNotNull()
                .isEqualTo(PosicaoBanda.BAIXO);
    }

}
