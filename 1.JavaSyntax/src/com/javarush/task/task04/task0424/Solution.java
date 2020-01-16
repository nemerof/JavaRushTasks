package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(rd.readLine());
        int number2 = Integer.parseInt(rd.readLine());
        int number3 = Integer.parseInt(rd.readLine());
        if (number1 == number2){
            System.out.println(3);
        }
        if (number1 == number3){
            System.out.println(2);
        }
        if (number2 == number3){
            System.out.println(1);
        }
    }
}
