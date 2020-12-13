package com.github.danielshiplett.advent.year2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day02Test {

    private Day02 day02;

    @BeforeEach
    public void beforeEach() {
        day02 = new Day02();
    }

    @Test
    public void testPart01() {
        day02.part01();
    }

    @Test
    public void testPart02() {
        day02.part02();
    }
}
