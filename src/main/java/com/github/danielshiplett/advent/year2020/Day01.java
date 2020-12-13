package com.github.danielshiplett.advent.year2020;

import java.io.IOException;
import java.util.List;

public class Day01 extends AbstractDay {

    private static final String RESOURCE_NAME = "2020/day01part01.txt";

    public String part01() throws IOException {
        List<Integer> expenses = getResourceAsIntegers(RESOURCE_NAME);
        int n = expenses.size();
        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }

                Integer ii = expenses.get(i);
                Integer jj = expenses.get(j);

                if(ii + jj == 2020) {
                    LOG.debug("ii: {}", ii);
                    LOG.debug("jj: {}", jj);
                    result =  ii * jj;
                }
            }
        }

        return "Day 01 - Part 01: " + result;
    }

    public String part02() throws IOException {
        List<Integer> expenses = getResourceAsIntegers(RESOURCE_NAME);
        int n = expenses.size();
        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((i == j) || (i == k) || (j == k)) {
                        continue;
                    }

                    Integer ii = expenses.get(i);
                    Integer jj = expenses.get(j);
                    Integer kk = expenses.get(k);

                    if (ii + jj + kk == 2020) {
                        LOG.debug("ii: {}", ii);
                        LOG.debug("jj: {}", jj);
                        LOG.debug("kk: {}", kk);
                        result = ii * jj * kk;
                    }
                }
            }
        }

        return "Day 01 - Part 02: " + result;
    }
}
