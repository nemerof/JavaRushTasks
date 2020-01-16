package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(rd.readLine());
        int data = inputStream.read();
        int max = 0;
        while (inputStream.available() > 0) {
            data = inputStream.read();
            if (data > max) {
                max = data;
            }
        }
        rd.close();
        inputStream.close();
        System.out.println(max);
    }
}
