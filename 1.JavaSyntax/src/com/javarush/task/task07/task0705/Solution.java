package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] list = new int[20];
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++){
            list[i] = Integer.parseInt(rd.readLine());
        }
        int[] list_mini1 = new int[10];
        int[] list_mini2 = new int[10];
        for (int i = 0; i < 10; i++){
            list_mini1[i] = list[i];
            list_mini2[i] = list[i+10];
        }
        for (int i = 0; i < 10; i++){
            System.out.println(list_mini2[i]);
        }
    }
}
