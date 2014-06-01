package com.smbtec.xo.querydsl.apt;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.DeclaredType;

import com.mysema.query.apt.DefaultConfiguration;

/**
 *
 * @author Lars Martin - lars.martin@smb-tec.com
 *
 */
public class DefaultXOAnnotationProcessorConfiguration extends DefaultConfiguration {

    private DeclaredType annotationType;

    public DefaultXOAnnotationProcessorConfiguration(RoundEnvironment roundEnv, Map<String, String> options, Set<String> keywords,
            Class<? extends Annotation> entitiesAnn, Class<? extends Annotation> entityAnn, Class<? extends Annotation> superTypeAnn,
            Class<? extends Annotation> embeddableAnn, Class<? extends Annotation> embeddedAnn, Class<? extends Annotation> skipAnn) {

        super(roundEnv, options, keywords, entitiesAnn, entityAnn, superTypeAnn, embeddableAnn, embeddedAnn, skipAnn);

        setUseFields(false);
    }

    @Override
    public boolean isValidGetter(ExecutableElement getter) {
        return super.isValidGetter(getter) && isValid(getter);
    }

    private boolean isValid(ExecutableElement getter) {
        return true;
    }

}
