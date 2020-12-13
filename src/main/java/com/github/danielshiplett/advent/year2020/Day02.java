package com.github.danielshiplett.advent.year2020;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day02 extends AbstractDay {

    private static final String RESOURCE_NAME = "2020/day02part01.txt";

    public String part01() throws IOException {
        AtomicInteger validCount = new AtomicInteger();

        getPasswordLines(RESOURCE_NAME).forEach(passwordLine -> {
            LOG.debug("passwordLine: {}", passwordLine);
            boolean valid = validatePasswordLinePart01(passwordLine);
            LOG.debug("valid: {}", valid);

            if(valid) {
                validCount.getAndIncrement();
            }
        });

        return "Day 02 - Part 01: " + validCount;
    }

    public String part02() throws IOException {
        AtomicInteger validCount = new AtomicInteger();

        getPasswordLines(RESOURCE_NAME).forEach(passwordLine -> {
            LOG.debug("passwordLine: {}", passwordLine);
            boolean valid = validatePasswordLinePart02(passwordLine);
            LOG.debug("valid: {}", valid);

            if(valid) {
                validCount.getAndIncrement();
            }
        });

        return "Day 02 - Part 02: " + validCount;
    }

    private boolean validatePasswordLinePart01(PasswordLine passwordLine) {
        int index = 0;
        int count = 0;

        while(index != -1) {
            index = passwordLine.getPassword().indexOf(passwordLine.getLetter(), index);

            if(index != -1) {
                count++;
                index++;
            }
        }

        LOG.debug("count: {}", count);

        if(count >= passwordLine.getMin() && count <= passwordLine.getMax()) {
            return true;
        }

        return false;
    }

    private boolean validatePasswordLinePart02(PasswordLine passwordLine) {
        char first = passwordLine.getPassword().charAt(passwordLine.getMin() - 1);
        char second = passwordLine.getPassword().charAt(passwordLine.getMax() - 1);

        LOG.debug("first: {} - {}", first, second);

        int count = 0;
        if(first == passwordLine.getLetter()) {
            count++;
        }

        if(second == passwordLine.getLetter()) {
            count++;
        }

        if(count == 1) {
            return true;
        }

        return false;
    }

    private PasswordLine parsePasswordLine(String passwordLine) {
        LOG.debug("passwordLine: {}", passwordLine);
        PasswordLine rtn = new PasswordLine();

        Pattern pattern = Pattern.compile("(\\d{1,2})-(\\d{1,2}) (\\w{1}): (\\w*)");

        Matcher matcher = pattern.matcher(passwordLine);
        matcher.matches();

        rtn.setMin(Integer.parseInt(matcher.group(1)));
        rtn.setMax(Integer.parseInt(matcher.group(2)));
        rtn.setLetter(matcher.group(3).charAt(0));
        rtn.setPassword(matcher.group(4));

        return rtn;
    }

    private Stream<PasswordLine> getPasswordLines(String resourceName) throws IOException {
        return this.getFileLinesAsStream(resourceName).map(this::parsePasswordLine);
    }

    private static class PasswordLine {
        int min;
        int max;
        char letter;
        String password;

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "PasswordLine{" +
                    "min=" + min +
                    ", max=" + max +
                    ", letter=" + letter +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
