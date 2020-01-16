package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rd.readLine());
        int b = Integer.parseInt(rd.readLine());
        if (a > b){
            System.out.println(b);
        }
        else if (a == b){
            System.out.println(a);
        }
        else{
            System.out.println(a);
        }

    }
}