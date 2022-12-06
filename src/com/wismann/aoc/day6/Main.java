package com.wismann.aoc.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day6.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static int solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        char[] chars = lines.get(0).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char char1 = chars[i];
            char char2 = chars[i+1];
            char char3 = chars[i+2];
            char char4 = chars[i+3];

            if (char1 != char2 && char1 != char3 && char1 != char4 && char2 != char3 && char2 != char4 && char3 != char4) {
                return i+3+1;
            }
        }

        return 0;
    }

    private static int solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        List<Integer> ints = lines.get(0).chars().boxed().collect(Collectors.toList());

        for (int i = 0; i < ints.size(); i++) {
            List<Integer> subList = ints.subList(i, i + 14);
            Set<Integer> set = new HashSet<>(subList);
            if (set.size() == 14) {
                return i+14;
            }
        }




        return 0;
    }
}
