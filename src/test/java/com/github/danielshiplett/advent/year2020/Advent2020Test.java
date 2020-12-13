package com.github.danielshiplett.advent.year2020;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class Advent2020Test {

    @ParameterizedTest
    @ArgumentsSource(DayProvider.class)
    public void test(AbstractDay day) {
        day.part01();
        day.part02();
    }

    static class DayProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(new Day01()),
                Arguments.of(new Day02())
            );
        }
    }
}
