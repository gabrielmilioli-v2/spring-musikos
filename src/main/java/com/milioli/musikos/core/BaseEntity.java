package com.milioli.musikos.core;

import java.io.Serializable;

public interface BaseEntity<ID extends Serializable> extends Serializable {
    ID getId();

    void setId(ID id);
}
