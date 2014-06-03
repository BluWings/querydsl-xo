package com.smbtec.xo.querydsl.domain.neo4j;

import com.buschmais.xo.api.annotation.Transient;
import com.buschmais.xo.neo4j.api.annotation.Indexed;
import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Person")
public interface Person {

    @Indexed
    String getLastName();

    void setLastName(String name);

    String getFirstName();

    void setFirstName();

    @Transient
    String getFullname();

    void setFullname();

}