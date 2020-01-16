package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rd.readLine());
        int b = Integer.parseInt(rd.readLine());
        int c = Integer.parseInt(rd.readLine());
        if (a == b && b == c && a == c){
            System.out.println(a + " " + b + " " + c);
        }
        else{
            if (a == b){
                System.out.println(a + " " + b);
            }
            if (a == c){
                System.out.println(a + " " + c);
            }
            if (b == c){
                System.out.println(b + " " + c);
            }
        }
    }
}