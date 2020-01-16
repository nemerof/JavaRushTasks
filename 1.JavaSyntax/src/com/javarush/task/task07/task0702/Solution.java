package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] list = new String[10];
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++){
            list[i] = rd.readLine();
        }
        for (int i = 0; i < 10; i++){
            System.out.println(list[9-i]);
        }
    }
}