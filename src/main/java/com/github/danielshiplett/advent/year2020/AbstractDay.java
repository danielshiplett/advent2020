package com.github.danielshiplett.advent.year2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDay implements DayOfCode {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractDay.class);

    public abstract String part01() throws IOException;
    public abstract String part02() throws IOException;

    protected URL getResourceUrl(String resourceName) {
        return getClass().getClassLoader().getResource(resourceName);
    }

    protected File getFile(String name) throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource(name).toURI());
    }

    protected Stream<String> getFileLinesAsStream(String resourceName) throws IOException {
        return Files.lines(Path.of(getResourceUrl(resourceName).getPath()));
    }

    protected List<Integer> getResourceAsIntegers(String resourceName) throws IOException {
        return getFileLinesAsStream(resourceName).map(Integer::valueOf).collect(Collectors.toList());
    }
}
