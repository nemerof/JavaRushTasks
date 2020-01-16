package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            char[] array = args[0].toCharArray();
            if (isSystem(array)) {
                for (int i = 2; i <= 36; i++) {
                    try {
                        BigInteger bi = new BigInteger(String.valueOf(array), i);
                        String s = bi.toString(i);
                        System.out.println(i);
                        break;
                    } catch (Exception e) {
                    }
                }
            } else {
                System.out.println("incorrect");
            }
        } catch (Exception e) {
        }
    }

    private static boolean isSystem(char[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i ++) {
            if (String.valueOf(array[i]).matches("[0-9a-zA-Z]")) {
                count ++;
            }
        }

        return count == array.length;
    }
}