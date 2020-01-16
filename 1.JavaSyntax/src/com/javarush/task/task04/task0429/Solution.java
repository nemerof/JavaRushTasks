package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(rd.readLine());
        int number2 = Integer.parseInt(rd.readLine());
        int number3 = Integer.parseInt(rd.readLine());
        int count_plus = 0;
        int count_minus = 0;
        if (number1 > 0){
            count_plus ++;
        }
        else if (number1 < 0){
            count_minus ++;
        }
        if (number2 > 0){
            count_plus ++;
        }
        else if (number2 < 0){
            count_minus ++;
        }
        if (number3 > 0){
            count_plus ++;
        }
        else if (number3 < 0){
            count_minus ++;
        }
        System.out.println("количество отрицательных чисел: " + count_minus);
        System.out.println("количество положительных чисел: " + count_plus);
    }
}
