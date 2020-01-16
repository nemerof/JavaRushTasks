package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        try {
            for (int i = 2; i <= 36; i ++) {
                BigInteger integer = new BigInteger(number);
                if (isPalindrom(integer, i)) {
                    set.add(i);
                }
            }
        } catch (NumberFormatException e) {

        }

        return set;
    }

    private static boolean isPalindrom(BigInteger integer, int radix) {
        String number = integer.toString(radix);
        return number.equals(new StringBuffer(number).reverse().toString());
    }
}