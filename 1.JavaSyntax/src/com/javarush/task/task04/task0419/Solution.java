package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rd.readLine());
        int b = Integer.parseInt(rd.readLine());
        int c = Integer.parseInt(rd.readLine());
        int d = Integer.parseInt(rd.readLine());
        int max = a;
        if (max <= a){
            max = a;
        }
        if (max <= b){
            max = b;
        }
        if (max <= c){
            max = c;
        }
        if (max <= d){
            max = d;
        }
        System.out.println(max);
    }
}
