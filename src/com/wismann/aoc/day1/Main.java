package com.wismann.aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        String filename = "resources/day1.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));

    }

    private static int solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        List<Integer> sums = new ArrayList<>();

        int tempSum = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                sums.add(tempSum);
                tempSum=0;
                continue;
            }
            tempSum = tempSum + Integer.valueOf(line);
        }

        int highest = sums.stream().max(Comparator.naturalOrder()).get();

        return highest;
    }

    private static int solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        List<Integer> sums = new ArrayList<>();

        int tempSum = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                sums.add(tempSum);
                tempSum=0;
                continue;
            }
            tempSum = tempSum + Integer.valueOf(line);
        }

        sums.sort(Comparator.reverseOrder());

        return sums.get(0)+sums.get(1)+sums.get(2);
    }
}
