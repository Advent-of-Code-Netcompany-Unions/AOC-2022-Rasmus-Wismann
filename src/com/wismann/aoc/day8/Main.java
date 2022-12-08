package com.wismann.aoc.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day8.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static int solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        int[][] arr = new int[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < lines.get(0).length(); j++) {
                arr[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(0).length(); j++) {
                if (isVisible(arr, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isEdgeTree(int[][] arr, int i, int j) {
        return (i == 0 || j == 0 || i == arr.length-1 || j == arr[0].length-1);
    }

    private static boolean isVisible(int[][] arr, int i, int j) {
        if (isEdgeTree(arr, i, j)) {
            return true;
        }

        int val = arr[i][j];

        boolean visible = true;
        for(int x = i-1; x >= 0; x--) {
            if (arr[x][j] >= val) {
                visible = false;
            }
        }
        if (visible) {
            return true;
        }

        visible = true;
        for(int x = i+1; x < arr.length; x++) {
            if (arr[x][j] >= val) {
                visible = false;
            }
        }
        if (visible) {
            return true;
        }

        visible = true;
        for(int y = j-1; y >= 0; y--) {
            if (arr[i][y] >= val) {
                visible = false;
            }
        }
        if (visible) {
            return true;
        }

        visible = true;
        for(int y = j+1; y < arr[0].length; y++) {
            if (arr[i][y] >= val) {
                visible = false;
            }
        }
        return visible;
    }
    private static int solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        int[][] arr = new int[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < lines.get(0).length(); j++) {
                arr[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(0).length(); j++) {
                int score = calcScore(arr, i, j);
                if (score > max) {
                    max = score;
                }
            }
        }

        return max;
    }

    private static int calcScore(int[][] arr, int i, int j) {
        if (isEdgeTree(arr, i, j)) {
            return 0;
        }

        int val = arr[i][j];

        int count1 = 0;
        for(int x = i-1; x >= 0; x--) {
            count1++;
            if (arr[x][j] >= val) {
                break;
            }
        }

        int count2 = 0;
        for(int x = i+1; x < arr.length; x++) {
            count2++;
            if (arr[x][j] >= val) {
                break;
            }
        }

        int count3 = 0;
        for(int y = j-1; y >= 0; y--) {
            count3++;
            if (arr[i][y] >= val) {
                break;
            }
        }

        int count4 = 0;
        for(int y = j+1; y < arr[0].length; y++) {
            count4++;
            if (arr[i][y] >= val) {
                break;
            }
        }

        return count1*count2*count3*count4;
    }

}