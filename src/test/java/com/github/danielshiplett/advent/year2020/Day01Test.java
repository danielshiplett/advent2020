package com.github.danielshiplett.advent.year2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day01Test {

    private Day01 day01;

    @BeforeEach
    public void beforeEach() {
        day01 = new Day01();
    }

    @Test
    public void testPart01() {
        day01.part01();
    }

    @Test
    public void testPart02() {
        day01.part02();
    }
}
