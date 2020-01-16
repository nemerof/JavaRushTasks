package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[15];
        int sum_even = 0;
        int sum_odd = 0;
        for (int i = 0; i < list.length; i++){
            list[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 15; i++){
            if (i == 0 || i % 2 == 0){
                sum_even += list[i];
            }
            else{
                sum_odd += list[i];
            }
        }
        if (sum_even > sum_odd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else{
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
