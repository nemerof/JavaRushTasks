package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String line;
        int countSymbols = 0, countSpaces = 0;
        ArrayList<Character> list = new ArrayList<>();

        while ((line = rd.readLine()) != null) {
            char[] array = line.toCharArray();
            for (char elem : array) {
                list.add(elem);
            }
        }

        for (char elem : list) {
            if (elem == ' ') {
                countSpaces++;
                countSymbols++;
            } else {
                countSymbols++;
            }
        }
        rd.close();
        System.out.printf("%.2f", (double) countSpaces * 100 / countSymbols);
    }
}
