package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println("1 + 2 = " + (1 + 2));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        return ((int)(centimetre / 100));
    }
}