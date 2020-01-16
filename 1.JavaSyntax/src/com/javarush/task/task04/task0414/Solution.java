package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        if ((number % 4 == 0 && number % 100 != 0) || (number % 400 == 0)){
            System.out.println("количество дней в году: 366");
        }
        else{
            System.out.println("количество дней в году: 365");
        }
    }
}