package com.github.danielshiplett.advent.year2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.stream.Stream;

public class Advent2020Test {

    private static final Logger LOG = LoggerFactory.getLogger(Advent2020Test.class);

    private static final Stream<Advent2020TestResult> ARGUMENTS = Stream.of(
            new Advent2020TestResult(new Day01(),
                    "Day 01 - Part 01: 913824",
                    "Day 01 - Part 02: 240889536"),
            new Advent2020TestResult(new Day02(),
                    "Day 02 - Part 01: 546",
                    "Day 02 - Part 02: 275")
    );

    @ParameterizedTest
    @ArgumentsSource(DayProvider.class)
    public void test(AbstractDay day, String expectedPart01Result, String expectedPart02Result) throws IOException {
        String actual;

        actual = day.part01();
        LOG.info(actual);
        Assertions.assertEquals(expectedPart01Result, actual);

        actual = day.part02();
        LOG.info(actual);
        Assertions.assertEquals(expectedPart02Result, actual);
    }

    static class DayProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return ARGUMENTS;
        }
    }

    static class Advent2020TestResult implements Arguments {
        private final DayOfCode dayOfCode;
        private final String expectedPart01Result;
        private final String expectedPart02Result;

        public Advent2020TestResult(DayOfCode dayOfCode, String expectedPart01Result, String expectedPart02Result) {
            this.dayOfCode = dayOfCode;
            this.expectedPart01Result = expectedPart01Result;
            this.expectedPart02Result = expectedPart02Result;
        }

        public DayOfCode getDayOfCode() {
            return dayOfCode;
        }

        public String getExpectedPart01Result() {
            return expectedPart01Result;
        }

        public String getExpectedPart02Result() {
            return expectedPart02Result;
        }

        @Override
        public Object[] get() {
            return new Object[] {
                    dayOfCode, expectedPart01Result, expectedPart02Result
            };
        }
    }
}
