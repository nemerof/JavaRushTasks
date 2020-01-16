package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        if (number == 0){
            System.out.println("ноль");
        }
        if (number < 0 && number % 2 == 0){
            System.out.println("отрицательное четное число");
        }
        if (number < 0 && number % 2 != 0){
            System.out.println("отрицательное нечетное число" );
        }
        if (number > 0 && number % 2 != 0){
            System.out.println("положительное нечетное число");
        }
        if (number > 0 && number % 2 == 0){
            System.out.println("положительное четное число");
        }
    }
}
