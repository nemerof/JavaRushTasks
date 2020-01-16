package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(rd.readLine());
        int data = inputStream.read();
        int min = inputStream.read();
        while (inputStream.available() > 0) {
            data = inputStream.read();
            if (data < min) {
                min = data;
            }
        }
        rd.close();
        inputStream.close();
        System.out.println(min);
    }
}
