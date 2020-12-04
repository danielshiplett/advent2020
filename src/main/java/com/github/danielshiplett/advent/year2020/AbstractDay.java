package com.github.danielshiplett.advent.year2020;

import java.io.File;
import java.net.URISyntaxException;

public class AbstractDay {

    protected File getFile(String name) throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource(name).toURI());
    }
}
