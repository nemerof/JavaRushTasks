package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        if(a>=max(b,c)){
            System.out.println(a+" "+max(b,c)+" "+min(b,c));
        }else if(b>=max(a,c)){
            System.out.println(b+" "+max(a,c)+" "+min(a,c));
        } else if(c>=max(a,b)) {
            System.out.println(c+" "+max(a,b)+" "+min(a,b));
        }
    }

    private static int min(int a, int b){
        return (a <= b) ? a : b;
    }

    private static int max(int a, int b){
        return (a >= b) ? a : b;
    }
}
