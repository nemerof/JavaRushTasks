package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static String keyWord = "world";

    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();

        int count = 0;
        FileReader fileReader = new FileReader(fileName);
        StringBuilder fileContent = new StringBuilder();

        while (fileReader.ready()) {
            fileContent.append((char)fileReader.read());
        }

        fileReader.close();

        List<String> listOfWords = new ArrayList<String>(Arrays.asList(fileContent.toString().split("\\b")));

        for(String s : listOfWords) {
            if(s.equals(keyWord)) {
                ++count;
            }
        }

        System.out.println(count);
    }
}
