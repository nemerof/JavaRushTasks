package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String inputName = rd.readLine();
        String outputName = rd.readLine();
        rd.close();
        FileReader fileReader = new FileReader(inputName);
        FileWriter fileWriter = new FileWriter(outputName);

        ArrayList<Integer> list = new ArrayList<>();

        while (fileReader.ready()) {
            int line = fileReader.read();
            list.add(line);
        }

        for (int i = 0; i < list.size(); i ++) {
            if (i % 2 == 1) {
                fileWriter.write(list.get(i));
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
