package com.smbtec.xo.querydsl.apt;

import java.util.Collections;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.tools.Diagnostic;

import com.buschmais.xo.api.annotation.Transient;
import com.mysema.query.annotations.QueryEmbeddable;
import com.mysema.query.annotations.QueryEmbedded;
import com.mysema.query.annotations.QueryEntities;
import com.mysema.query.annotations.QuerySupertype;
import com.mysema.query.apt.AbstractQuerydslProcessor;
import com.mysema.query.apt.Configuration;
import com.mysema.query.apt.DefaultConfiguration;
import com.smbtec.xo.tinkerpop.blueprints.api.annotation.Vertex;

/**
 *
 * @author Lars Martin - lars.martin@smb-tec.com
 *
 */
@SupportedAnnotationTypes({ "com.mysema.query.annotations.*", "com.smbtec.xo.tinkerpop.blueprints.api.annotation.*" })
public class XOTinkerPopAnnotationProcessor extends AbstractQuerydslProcessor {

    @Override
    protected Configuration createConfiguration(RoundEnvironment roundEnv) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Running " + getClass().getSimpleName());

        DefaultConfiguration configuration = new DefaultXOAnnotationProcessorConfiguration(roundEnv, processingEnv.getOptions(),
                Collections.<String> emptySet(), QueryEntities.class, Vertex.class, QuerySupertype.class, QueryEmbeddable.class, QueryEmbedded.class,
                Transient.class);
        return configuration;
    }

}
