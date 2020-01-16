package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        int number_len = Integer.toString(number).length();
        for (int i = 0; i < number_len; i++){
            if (number % 2 == 0){
                even ++;
            }
            else{
                odd ++;
            }
            number /= 10;

        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
