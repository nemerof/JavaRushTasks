package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int number = Integer.parseInt(rd.readLine());
            sum += number;
            if (number == -1){
                break;
            }
        }
        System.out.println(sum);
    }
}
