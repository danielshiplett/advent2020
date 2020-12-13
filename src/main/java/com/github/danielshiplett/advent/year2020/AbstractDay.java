package com.github.danielshiplett.advent.year2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class AbstractDay {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractDay.class);

    protected URL getResourceUrl(String resourceName) {
        return getClass().getClassLoader().getResource(resourceName);
    }

    protected File getFile(String name) throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource(name).toURI());
    }

    protected Stream<String> getFileLinesAsStream(String resourceName) throws IOException {
        return Files.lines(Path.of(getResourceUrl(resourceName).getPath()));
    }
}
