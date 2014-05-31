package com.smbtec.xo.querydsl.domain.tinkerpop;

import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Indexed;
import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Vertex;

@Vertex("Person")
public interface Person {

    @Indexed
    String getName();

    void setName(String name);
}