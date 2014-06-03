package com.smbtec.xo.querydsl.domain.tinkerpop;

import com.buschmais.xo.api.annotation.Transient;
import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Indexed;
import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Vertex;

@Vertex("Person")
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