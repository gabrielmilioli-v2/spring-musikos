package com.milioli.musikos.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.milioli.musikos.utils.PersistableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum Instrument implements PersistableEnum<Long> {

    OUTRO(1L, "Outro"),
    GUITARRA(2L, "Guitarra"),
    BAIXO(3L, "Baixo"),
    BATERIA(4L, "Bateria"),
    VOCAL(5L, "Vocal");

    private final Long id;
    private final String description;

    private static final Map<String, Instrument> FORMAT_MAP = Stream
            .of(Instrument.values())
            .collect(Collectors.toMap(Instrument::getDescription, Function.identity()));

    @JsonCreator
    public static Instrument fromString(Map<String, String> map) {
        return Optional
                .ofNullable(FORMAT_MAP.get(map.get("description")))
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found."));
    }
}
