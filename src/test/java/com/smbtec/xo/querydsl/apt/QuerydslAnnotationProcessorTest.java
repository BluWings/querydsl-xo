package com.smbtec.xo.querydsl.apt;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 *
 * @author Lars Martin - lars.martin@smb-tec.com
 *
 */
public class QuerydslAnnotationProcessorTest extends AbstractProcessorTest {

    private static final String PACKAGE_PATH = "src/test/java/com/smbtec/xo/querydsl/domain/";

    private static final List<String> CLASSES = getFiles(PACKAGE_PATH);

    @Test
    public void Process() throws IOException {
        File file = new File(PACKAGE_PATH, "Person.java");
        process(XONeo4jAnnotationProcessor.class, Collections.singletonList(file.getPath()), "qdsl");
    }

}
