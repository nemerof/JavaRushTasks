package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(rd.readLine());
        char c = ',';
        int count = 0;

        while (inputStream.available() > 0) {
            int data = inputStream.read();

            if (data == (int) c) {
                count ++;
            }
        }
        rd.close();
        inputStream.close();
        System.out.println(count);
    }
}
