package com.smbtec.xo.querydsl.apt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.annotation.processing.AbstractProcessor;

import com.mysema.codegen.SimpleCompiler;
import com.mysema.util.FileUtils;

import junit.framework.Assert;

/**
 *
 * @author Lars Martin - lars.martin@smb-tec.com
 *
 * (copied from querydsl core)
 *
 */
public abstract class AbstractProcessorTest {

    private final JavaCompiler compiler = new SimpleCompiler();

    protected static List<String> getFiles(String path) {
        List<String> classes = new ArrayList<String>();
        for (File file : new File(path).listFiles()) {
            if (file.getName().endsWith(".java")) {
                classes.add(file.getPath());
            } else if (file.isDirectory() && !file.getName().startsWith(".")) {
                classes.addAll(getFiles(file.getAbsolutePath()));
            }
        }
        return classes;
    }

    protected void process(Class<? extends AbstractProcessor> processorClass, List<String> classes, String target) throws IOException {
        File out = new File("target/" + target);
        FileUtils.delete(out);
        if (!out.mkdirs()) {
            Assert.fail("Creation of " + out.getPath() + " failed");
        }
        compile(processorClass, classes, target);
    }

    protected void compile(Class<? extends AbstractProcessor> processorClass, List<String> classes, String target) throws IOException {
        List<String> options = new ArrayList<String>(classes.size() + 3);
        options.add("-s");
        options.add("target/" + target);
        options.add("-proc:only");
        options.add("-processor");
        options.add(processorClass.getName());
        options.add("-sourcepath");
        options.add("src/test/java");
        options.addAll(getAPTOptions());
        options.addAll(classes);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        int compilationResult = compiler.run(null, out, err, options.toArray(new String[options.size()]));

        // Processor.elementCache.clear();
        if (compilationResult != 0) {
            System.err.println(compiler.getClass().getName());
            Assert.fail("Compilation Failed");
        }
    }

    protected Collection<String> getAPTOptions() {
        return Collections.emptyList();
    }

}
