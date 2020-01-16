package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(rd.readLine());
        int number2 = Integer.parseInt(rd.readLine());
        if (number1 > 0 && number2 > 0){
            System.out.println(1);
        }
        if (number1 > 0 && number2 < 0){
            System.out.println(4);
        }
        if (number1 < 0 && number2 < 0){
            System.out.println(3);
        }
        if (number1 < 0 && number2 > 0){
            System.out.println(2);
        }
    }
}
