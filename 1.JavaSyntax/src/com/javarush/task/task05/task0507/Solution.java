package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        int count = 0;

        for (int i=0;;i++) {
            double m = Double.parseDouble(reader.readLine());
            if (m == -1) {
                double sr = sum/count;
                System.out.println(sr);
                break;}
            sum = sum + m;
            count++;
        }

    }
}

