package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(125));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;

        while ((n % 3) == 0) {
            n = n / 3;
        }

        return n == 1;
    }
}
