package com.milioli.musikos.converter;

import com.milioli.musikos.enums.Instrument;
import com.milioli.musikos.utils.PersistableEnumConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InstrumentConverter extends PersistableEnumConverter<Instrument, Long> {

    public InstrumentConverter() {
        super(Instrument.class);
    }

}
