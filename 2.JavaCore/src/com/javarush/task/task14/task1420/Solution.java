package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number1 = Integer.parseInt(reader.readLine());
        if (number1 <= 0) throw new Exception();
        int number2 = Integer.parseInt(reader.readLine());
        if (number2 <= 0) throw new Exception();
        int nod = 1;

        for (int i = Math.max(number1, number2); i > 0; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                nod = i;
                break;
            }
        }

        System.out.println(nod);
    }
}
