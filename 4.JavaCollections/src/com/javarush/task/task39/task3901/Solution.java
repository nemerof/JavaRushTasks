package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] array = s.toLowerCase().toCharArray();
        int count = 1;
        int maxCount = 0;
        StringBuffer sb = new StringBuffer("" + array[0]);
        for (int i = 1; i < array.length; i ++) {
            if (containsChar(sb.toString(), array[i])) {
                maxCount = count;
                count = 1;
                sb = new StringBuffer("" + array[i]);
            } else {
                count++;
                sb.append(array[i]);
            }
        }
        return maxCount;
    }

    private static boolean containsChar(String string, char c) {
        for (char c1 : string.toCharArray()) {
            if (c1 == c) {
                return true;
            }
        }
        return false;
    }
}
