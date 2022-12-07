package com.wismann.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Folder> folders = new ArrayList<>();
    private Folder parrentFolder;

    public Folder(String name, Folder parrentFolder) {
        this.name = name;
        this.parrentFolder = parrentFolder;
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public Folder getParrentFolder() {
        return parrentFolder;
    }

    public long getTotalSize() {
        long filesSize = files.stream().map(File::getSize).reduce(0L, Long::sum);
        long folderSize = folders.stream().map(Folder::getTotalSize).reduce(0L, Long::sum);
        return folderSize + filesSize;
    }
}
