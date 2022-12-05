package com.wismann.aoc.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day5.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static String solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        List<Stack<String>> stacks = new ArrayList<>();
        stacks.add(createStack(Arrays.asList("T", "D", "W", "Z", "V", "P")));
        stacks.add(createStack(Arrays.asList("L", "S", "W", "V", "F", "J", "D")));
        stacks.add(createStack(Arrays.asList("Z", "M", "L", "S", "V", "T", "B", "H")));
        stacks.add(createStack(Arrays.asList("R", "S", "J")));
        stacks.add(createStack(Arrays.asList("C", "Z", "B", "G", "F", "M", "L", "W")));
        stacks.add(createStack(Arrays.asList("Q", "W", "V", "H", "Z", "R", "G", "B")));
        stacks.add(createStack(Arrays.asList("V", "J", "P", "C", "B", "D", "N")));
        stacks.add(createStack(Arrays.asList("P", "T", "B", "Q")));
        stacks.add(createStack(Arrays.asList("H", "G", "Z", "R", "C")));

        for (int i = 10; i < lines.size(); i++) {
            String operation = lines.get(i);
            String[] split = operation.replaceAll("[^0-9]+", " ").trim().split(" ");

            int amount = Integer.parseInt(split[0]);
            int moveFrom = Integer.parseInt(split[1]);
            int moveTo = Integer.parseInt(split[2]);

            Stack<String> moveFromStack = stacks.get(moveFrom - 1);
            Stack<String> moveToStack = stacks.get(moveTo - 1);

            for (int j = 0; j < amount; j++) {
                String pop = moveFromStack.pop();
                moveToStack.push(pop);
            }
        }

        String message = "";
        for (Stack<String> stack : stacks) {
            message += stack.pop();
        }

        return message;
    }

    private static Stack<String> createStack(List<String> list) {
        Stack<String> stack = new Stack<>();
        stack.addAll(list);
        return stack;
    }

    private static String solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());

        List<Stack<String>> stacks = new ArrayList<>();
        stacks.add(createStack(Arrays.asList("T", "D", "W", "Z", "V", "P")));
        stacks.add(createStack(Arrays.asList("L", "S", "W", "V", "F", "J", "D")));
        stacks.add(createStack(Arrays.asList("Z", "M", "L", "S", "V", "T", "B", "H")));
        stacks.add(createStack(Arrays.asList("R", "S", "J")));
        stacks.add(createStack(Arrays.asList("C", "Z", "B", "G", "F", "M", "L", "W")));
        stacks.add(createStack(Arrays.asList("Q", "W", "V", "H", "Z", "R", "G", "B")));
        stacks.add(createStack(Arrays.asList("V", "J", "P", "C", "B", "D", "N")));
        stacks.add(createStack(Arrays.asList("P", "T", "B", "Q")));
        stacks.add(createStack(Arrays.asList("H", "G", "Z", "R", "C")));

        for (int i = 10; i < lines.size(); i++) {
            String operation = lines.get(i);
            String[] split = operation.replaceAll("[^0-9]+", " ").trim().split(" ");

            int amount = Integer.parseInt(split[0]);
            int moveFrom = Integer.parseInt(split[1]);
            int moveTo = Integer.parseInt(split[2]);

            Stack<String> moveFromStack = stacks.get(moveFrom - 1);
            Stack<String> moveToStack = stacks.get(moveTo - 1);

            List<String> tempList = new ArrayList<>();

            for (int j = 0; j < amount; j++) {
                String pop = moveFromStack.pop();
                tempList.add(pop);
            }
            Collections.reverse(tempList);
            moveToStack.addAll(tempList);
        }

        String message = "";
        for (Stack<String> stack : stacks) {
            message += stack.pop();
        }

        return message;
    }
}
