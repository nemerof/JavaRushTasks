package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        if (number > 0){
            System.out.println(number * 2);
        }
        if (number < 0){
            System.out.println(number + 1);
        }
        if (number == 0){
            System.out.println(0);
        }

    }

}