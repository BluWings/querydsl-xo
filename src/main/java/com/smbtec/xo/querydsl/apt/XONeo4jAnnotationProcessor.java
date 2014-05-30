package com.smbtec.xo.querydsl.apt;

import java.util.Collections;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.tools.Diagnostic;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.mysema.query.annotations.QueryEmbeddable;
import com.mysema.query.annotations.QueryEmbedded;
import com.mysema.query.annotations.QueryEntities;
import com.mysema.query.annotations.QuerySupertype;
import com.mysema.query.annotations.QueryTransient;
import com.mysema.query.apt.AbstractQuerydslProcessor;
import com.mysema.query.apt.Configuration;
import com.mysema.query.apt.DefaultConfiguration;

/**
 *
 * @author Lars Martin - lars.martin@smb-tec.com
 *
 */
@SupportedAnnotationTypes({ "com.mysema.query.annotations.*", "com.buschmais.xo.neo4j.api.annotation.*" })
public class XONeo4jAnnotationProcessor extends AbstractQuerydslProcessor {

    @Override
    protected Configuration createConfiguration(RoundEnvironment roundEnv) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Running " + getClass().getSimpleName());

        DefaultConfiguration configuration = new DefaultXONeo4jAnnotationProcessorConfiguration(roundEnv, processingEnv.getOptions(),
                Collections.<String> emptySet(), QueryEntities.class, Label.class, QuerySupertype.class, QueryEmbeddable.class, QueryEmbedded.class, QueryTransient.class);
        return configuration;
    }

}
