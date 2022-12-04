package com.wismann.aoc.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day4.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static int solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        int count = 0;

        for (String line : lines) {
            String[] pairs = line.split(",");
            String[] pair1 = pairs[0].split("-");
            String[] pair2 = pairs[1].split("-");
            int pair1Start = Integer.parseInt(pair1[0]);
            int pair1End = Integer.parseInt(pair1[1]);
            int pair2Start = Integer.parseInt(pair2[0]);
            int pair2End = Integer.parseInt(pair2[1]);

            Set<Integer> s1 = new HashSet<>();
            for (int i = pair1Start; i < pair1End+1; i++) {
                s1.add(i);
            }

            Set<Integer> s2 = new HashSet<>();
            for (int i = pair2Start; i < pair2End+1; i++) {
                s2.add(i);
            }

            if (s1.containsAll(s2) || s2.containsAll(s1)) {
                count++;
            }

        }

        return count;
    }

    private static int solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        int count = 0;

        for (String line : lines) {
            String[] pairs = line.split(",");
            String[] pair1 = pairs[0].split("-");
            String[] pair2 = pairs[1].split("-");
            int pair1Start = Integer.parseInt(pair1[0]);
            int pair1End = Integer.parseInt(pair1[1]);
            int pair2Start = Integer.parseInt(pair2[0]);
            int pair2End = Integer.parseInt(pair2[1]);

            Set<Integer> s1 = new HashSet<>();
            for (int i = pair1Start; i < pair1End+1; i++) {
                s1.add(i);
            }

            Set<Integer> s2 = new HashSet<>();
            for (int i = pair2Start; i < pair2End+1; i++) {
                s2.add(i);
            }

            if (s1.stream().anyMatch(s2::contains)) {
                count++;
            }

        }

        return count;
    }
}
