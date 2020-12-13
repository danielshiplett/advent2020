package com.github.danielshiplett.advent.year2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day01 extends AbstractDay {

    public void part01() {
        List<Integer> expenses = getExpenses("2020/day01part01.txt");
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

        LOG.info("Day 01 - Part 01: {}", result);
    }

    public void part02() {
        List<Integer> expenses = getExpenses("2020/day01part01.txt");
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

        LOG.info("Day 01 - Part 02: {}", result);
    }

    private List<Integer> getExpenses(String fileName) {
        List<Integer> expenses = null;

        try (BufferedReader br = new BufferedReader(new FileReader(getFile(fileName)))) {
            expenses = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                expenses.add(Integer.valueOf(line));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return expenses;
    }
}
