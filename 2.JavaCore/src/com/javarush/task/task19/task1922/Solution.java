package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();
        BufferedReader rd1 = new BufferedReader(new FileReader(fileName));
        int count = 0;

        String line;
        while ((line = rd1.readLine()) != null) {
            String[] array = line.split(" ");
            for (String elem : array) {
                for (String word : words) {
                    if (elem.equals(word)) {
                        count ++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(line);
            }

            count = 0;
        }

        rd1.close();
    }
}
