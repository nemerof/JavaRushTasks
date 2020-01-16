package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(rd.readLine());
        int number2 = Integer.parseInt(rd.readLine());
        int number3 = Integer.parseInt(rd.readLine());
        int count = 0;
        if (number1 > 0){
            count ++;
        }
        if (number2 > 0){
            count ++;
        }
        if (number3 > 0){
            count ++;
        }
        System.out.println(count);
    }
}
