package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String directoryPath = args[0];

        File sourse = new File(args[1]);
        File destination = new File(sourse.getParent().substring(1) + "/allFilesContent.txt");

        FileUtils.renameFile(new File(sourse.getPath().substring(1)), destination);

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(destination));

        List<File> files = new ArrayList<>();

        Files.walkFileTree(Paths.get(directoryPath.substring(1)), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toFile().length() > 50){
                    FileUtils.deleteFile(file.toFile());
                }
                else
                    files.add(file.toFile());

                return FileVisitResult.CONTINUE;
            }
        });

        files.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        for (File file: files){
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while (fileReader.ready()){
                fileWriter.write(fileReader.readLine());
                fileWriter.newLine();
            }
            fileReader.close();
        }

        fileWriter.close();
    }
}
