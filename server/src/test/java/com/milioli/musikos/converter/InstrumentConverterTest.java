package com.milioli.musikos.converter;

import com.milioli.musikos.enums.Instrument;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstrumentConverterTest {

    @Test
    void convertToDatabaseColumn() {
        final InstrumentConverter converter = new InstrumentConverter();
        final Long id = converter.convertToDatabaseColumn(Instrument.BAIXO);
        Assertions.assertThat(id)
                .isNotNull()
                .isEqualTo(Instrument.BAIXO.getId());
    }

    @Test
    void convertToEntityAttribute() {
        final InstrumentConverter converter = new InstrumentConverter();
        final Instrument instrument = converter.convertToEntityAttribute(3L);
        Assertions.assertThat(instrument)
                .isNotNull()
                .isEqualTo(Instrument.BAIXO);
    }

}
