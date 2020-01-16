package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int[] int_array = new int[10];
        String[] string_array = new String[10];
        for (int i = 0; i < 10; i++){
            string_array[i] = rd.readLine();
        }
        for (int i = 0; i < 10; i++){
            int_array[i] = string_array[i].length();
        }
        for (int i = 0; i < 10; i++){
            System.out.println(int_array[i]);
        }
    }
}
