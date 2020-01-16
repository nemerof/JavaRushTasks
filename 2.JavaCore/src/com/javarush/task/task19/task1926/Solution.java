package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();
        BufferedReader rd1 = new BufferedReader(new FileReader(fileName));

        while (rd1.ready()) {
            String input = rd1.readLine();
            StringBuilder input1 = new StringBuilder();
            input1.append(input);
            input1 = input1.reverse();
            System.out.println(input1);
        }

        rd1.close();
    }
}
