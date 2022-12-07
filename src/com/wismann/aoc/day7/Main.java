package com.wismann.aoc.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "resources/day7.txt";

        System.out.println(solveFirstProblem(filename));
        System.out.println(solveSecondProblem(filename));
    }

    private static Folder buildFileStructure(List<String> input) {
        Folder mainDir = new Folder("/", null);
        Folder currentDir = mainDir;
        int currentLine = 0;

        while (currentLine < input.size()) {
            String command = input.get(currentLine);
            if (command.equals("$ ls")) {
                // Do nothing
            }

            else if (command.equals("$ cd ..")) {
                currentDir = currentDir.getParrentFolder();
            }

            else if (command.matches("\\$ cd [a-z]+")) {
                Folder moveToFolder = currentDir.getFolders().stream()
                        .filter(f -> f.getName().equals(command.split(" ")[2]))
                        .findFirst().get();

                currentDir = moveToFolder;
            }

            else {
                String[] split = command.split(" ");
                if (split[0].equals("dir")) {
                    currentDir.addFolder(new Folder(split[1], currentDir));
                }
                else {
                    currentDir.addFile(new File(split[1], Integer.parseInt(split[0])));
                }
            }
            currentLine++;
        }

        return mainDir;
    }

    private static long solveFirstProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        Folder folder = buildFileStructure(lines.subList(1, lines.size()));

        List<Folder> allFolders = new ArrayList<>();
        addFolders(allFolders, folder);

        long sum = 0L;
        for (Folder fold : allFolders) {
            Long reduce = fold.getFolders().stream()
                    .filter(f -> f.getTotalSize() <= 100000L)
                    .map(Folder::getTotalSize)
                    .reduce(0L, Long::sum);
            sum+=reduce;
        }

        return sum;
    }

    private static void addFolders(List<Folder> allFolders, Folder folder) {
        allFolders.add(folder);
        if (!folder.getFolders().isEmpty()) {
            folder.getFolders().forEach(f -> addFolders(allFolders, f));
        }
    }

    private static long solveSecondProblem(String inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        Folder folder = buildFileStructure(lines.subList(1, lines.size()));

        long unusedSpace = 70000000L - folder.getTotalSize();
        long spaceNeeded = 30000000L - unusedSpace;

        List<Folder> allFolders = new ArrayList<>();
        addFolders(allFolders, folder);

        return allFolders.stream()
                .map(Folder::getTotalSize)
                .filter(size -> size >= spaceNeeded)
                .min(Comparator.naturalOrder())
                .get();

    }
}
