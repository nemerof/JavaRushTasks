package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rd.readLine());
        int b = Integer.parseInt(rd.readLine());
        int c = Integer.parseInt(rd.readLine());
        if (a + b > c & a + c > b & b + c > a){
            System.out.println("Треугольник существует.");
        }
        else{
            System.out.println("Треугольник не существует.");
        }
    }
}