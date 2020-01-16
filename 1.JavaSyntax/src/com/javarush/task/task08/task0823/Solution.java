package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] strToArray = s.toCharArray();
        strToArray[0] = String.valueOf(strToArray[0]).toUpperCase().charAt(0);
        for (int i = 0; i < strToArray.length; i ++) {
            if (strToArray[i] == ' ') {
                String edit = String.valueOf(strToArray[i + 1]).toUpperCase();
                strToArray[i + 1] = edit.charAt(0);
            }
        }

        System.out.println(new String(strToArray));
    }
}
