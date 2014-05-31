package com.smbtec.xo.querydsl.apt;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;

import com.mysema.query.apt.DefaultConfiguration;

/**
 *
 * @author Lars Martin - lars.martin@smb-tec.com
 *
 */
public class DefaultXOAnnotationProcessorConfiguration extends DefaultConfiguration {

    public DefaultXOAnnotationProcessorConfiguration(RoundEnvironment roundEnv, Map<String, String> options, Set<String> keywords,
            Class<? extends Annotation> entitiesAnn, Class<? extends Annotation> entityAnn, Class<? extends Annotation> superTypeAnn,
            Class<? extends Annotation> embeddableAnn, Class<? extends Annotation> embeddedAnn, Class<? extends Annotation> skipAnn) {

        super(roundEnv, options, keywords, entitiesAnn, entityAnn, superTypeAnn, embeddableAnn, embeddedAnn, skipAnn);

        setUseFields(false);
    }

}
