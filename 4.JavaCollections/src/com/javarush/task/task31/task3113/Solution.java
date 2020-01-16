package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static int allDirectories = 0;
    static int allFiles = 0;
    static int allBytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        Path pathToDirectory = Paths.get(path);
        if (!Files.isDirectory(pathToDirectory)) {
            System.out.println(pathToDirectory.toString() + " - не папка");
            return;
        }

        Files.walkFileTree(pathToDirectory, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (!dir.equals(pathToDirectory)) {
                    allDirectories ++;
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                allFiles ++;
                allBytes += attrs.size();

                return FileVisitResult.CONTINUE;
            }
        });
        //checkSize(new File(path));

        System.out.println("Всего папок - " + allDirectories);
        System.out.println("Всего файлов - " + allFiles);
        System.out.println("Общий размер - " + allBytes);

    }

    /*public static void checkSize(File file) {

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    allDirectories ++;
                    checkSize(f);
                } else {
                    allFiles ++;
                    allBytes += f.length();
                }
            }
        }
        else {
            allFiles ++;
            allBytes += file.length();
        }
    } */
}
