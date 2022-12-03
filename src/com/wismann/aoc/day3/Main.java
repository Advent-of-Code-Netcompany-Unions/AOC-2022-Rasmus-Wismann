package com.wismann.aoc.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day3.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static int solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        int sum = 0;

        for (String line : lines) {
            char[] chars1 = line.substring(0, line.length() / 2).toCharArray();
            char[] chars2 = line.substring(line.length() / 2).toCharArray();

            char commonChar = '&';
            for (char c1 : chars1) {
                for (char c2 : chars2) {
                    if (c1==c2) {
                        commonChar = c1;
                    }
                }
            }

            if (commonChar > 96 && commonChar < 123) {
                sum = sum + (commonChar-96);
            }
            else if (commonChar > 64 && commonChar < 91) {
                sum = sum + (commonChar-38);
            }
        }

        return sum;
    }

    private static int solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        int sum = 0;

        for (int i = 0; i < lines.size(); i = i + 3) {
            char[] chars1 = lines.get(i).toCharArray();
            char[] chars2 = lines.get(i+1).toCharArray();
            char[] chars3 = lines.get(i+2).toCharArray();

            char commonChar = '&';
            for (char c1 : chars1) {
                for (char c2 : chars2) {
                    for (char c3 : chars3) {
                        if (c1==c2 && c1==c3) {
                            commonChar = c1;
                        }
                    }
                }
            }

            if (commonChar > 96 && commonChar < 123) {
                sum = sum + (commonChar-96);
            }
            else if (commonChar > 64 && commonChar < 91) {
                sum = sum + (commonChar-38);
            }
        }

        return sum;
    }
}
