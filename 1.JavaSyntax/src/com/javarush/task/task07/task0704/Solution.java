package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[10];
        for (int i = 0; i < 10; i++){
            list[i] = Integer.parseInt(rd.readLine());
        }
        for (int i = 0; i < 10; i++){
            System.out.println(list[9-i]);
        }
    }
}