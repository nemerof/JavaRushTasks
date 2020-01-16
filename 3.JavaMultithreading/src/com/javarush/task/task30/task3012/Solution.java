package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        /*BigInteger bigInteger = new BigInteger(String.valueOf(number));
        String triple = bigInteger.toString(3);
        char[] chars = triple.toCharArray();
        int[] simmTriple = new int[chars.length];

        for (int i = chars.length - 1; i >= 0; i --) {
            int i1 = Integer.parseInt(String.valueOf(chars[i]));
            if (i1 == 2) {
                simmTriple[i] = -1;
                chars[i - 1] = (char) ((Integer.parseInt(String.valueOf(chars[i - 1])) + 1) + '0');
            } else if (i1 == 3) {
                simmTriple[i] = 0;
            } else {
                simmTriple[i] = i1;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i : simmTriple) {
            builder.append(i);
        }
        System.out.println(builder.toString()); */
        int x = number;
        List<Integer> intermediate = new ArrayList<>();
        while (x >= 3) {
            if (x % 3 == 2) {
                x = (x / 3) + 1;
                intermediate.add(-1);
            } else {
                intermediate.add(x % 3);
                x /= 3;
            }
        }
        if (x == 2) {
            intermediate.add(-1);
            intermediate.add(1);
        } else {
            intermediate.add(x);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = intermediate.size() - 1; i >= 0; i --) {
            int n = (int) Math.pow(3, intermediate.size() - (i + 1)) * intermediate.get(intermediate.size() - i - 1);
            if (n != 0) {
                result.add(n);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            if (i >= 0) {
                sb.append(" + ").append(i);
            } else {
                sb.append(" - ").append(Math.abs(i));
            }
        }
        System.out.println(String.format("%d = %s", number, sb.toString().trim()));

    }
}