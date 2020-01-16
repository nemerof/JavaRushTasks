package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(reader.readLine());
        int digit = Integer.parseInt(reader.readLine());
        int maximum = digit;

        for (int i = 1; i < amount; i++){
            digit = Integer.parseInt(reader.readLine());
            if (digit > maximum){
                maximum = digit;
            }
        }

        System.out.println(maximum);
    }
}
