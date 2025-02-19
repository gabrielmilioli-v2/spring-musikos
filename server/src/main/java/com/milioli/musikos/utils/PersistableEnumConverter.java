package com.milioli.musikos.utils;

import jakarta.persistence.AttributeConverter;

public abstract class PersistableEnumConverter<E extends PersistableEnum<T>, T> implements AttributeConverter<E, T> {

    private final Class<E> enumType;

    public PersistableEnumConverter(final Class<E> enumType) {
        this.enumType = enumType;
    }

    @Override
    public T convertToDatabaseColumn(final E enumEntity) {
        return enumEntity.getId();
    }

    @Override
    public E convertToEntityAttribute(T id) {
        for (E enumConstant : enumType.getEnumConstants()) {
            if (enumConstant.getId().equals(id)) {
                return enumConstant;
            }
        }
        throw new IllegalStateException(String.format("Não foi encontrada a enum de valor %s.", id));
    }
}
