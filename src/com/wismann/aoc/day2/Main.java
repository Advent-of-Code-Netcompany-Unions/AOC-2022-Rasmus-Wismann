package com.wismann.aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day2.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static int solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        int score = 0;

        for (String line : lines) {
            String[] s = line.split(" ");
            if (s[0].equals("A") && s[1].equals("X")) {
                score = score + 3 + 1;
            }
            if (s[0].equals("B") && s[1].equals("X")) {
                score = score + 1;
            }
            if (s[0].equals("C") && s[1].equals("X")) {
                score = score + 6 + 1;
            }

            if (s[0].equals("A") && s[1].equals("Y")) {
                score = score + 6 + 2;
            }
            if (s[0].equals("B") && s[1].equals("Y")) {
                score = score + 3 + 2;
            }
            if (s[0].equals("C") && s[1].equals("Y")) {
                score = score + 2;
            }

            if (s[0].equals("A") && s[1].equals("Z")) {
                score = score + 3;
            }
            if (s[0].equals("B") && s[1].equals("Z")) {
                score = score + 6 + 3;
            }
            if (s[0].equals("C") && s[1].equals("Z")) {
                score = score + 3 + 3;
            }


        }
        return score;
    }

    private static int solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        int score = 0;

        for (String line : lines) {
            String[] s = line.split(" ");
            // Sten vs saks
            if (s[0].equals("A") && s[1].equals("X")) {
                score = score + 3;
            }
            // Papir vs. sten
            if (s[0].equals("B") && s[1].equals("X")) {
                score = score + 1;
            }
            // Saks vs. papir
            if (s[0].equals("C") && s[1].equals("X")) {
                score = score + 2;
            }

            // Sten vs sten
            if (s[0].equals("A") && s[1].equals("Y")) {
                score = score + 3 + 1;
            }
            // Papir vs papir
            if (s[0].equals("B") && s[1].equals("Y")) {
                score = score + 3 + 2;
            }
            // Saks vs saks
            if (s[0].equals("C") && s[1].equals("Y")) {
                score = score + 3 + 3;
            }

            // Sten vs. papir
            if (s[0].equals("A") && s[1].equals("Z")) {
                score = score + 6 + 2;
            }
            // Papir vs. saks
            if (s[0].equals("B") && s[1].equals("Z")) {
                score = score + 6 + 3;
            }
            if (s[0].equals("C") && s[1].equals("Z")) {
                score = score + 6 + 1;
            }


        }
        return score;
    }
}
