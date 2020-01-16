package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        String number2 = String.valueOf(number);
        if (number >= 1 && number <= 999){
            if (number2.length() == 1 && number % 2 != 0){
                System.out.println("нечетное однозначное число");
            }
            if (number2.length() == 1 && number % 2 == 0){
                System.out.println("четное однозначное число");
            }
            if (number2.length() == 2 && number % 2 != 0){
                System.out.println("нечетное двузначное число");
            }
            if (number2.length() == 2 && number % 2 == 0){
                System.out.println("четное двузначное число");
            }
            if (number2.length() == 3 && number % 2 != 0){
                System.out.println("нечетное трехзначное число");
            }
            if (number2.length() == 3 && number % 2 == 0){
                System.out.println("четное трехзначное число");
            }
        }

    }
}