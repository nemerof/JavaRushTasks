package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i1 = 1;
        int i2 = 1;
        System.out.print("S");
        while (i1 < 11){
            while (i2 < 9) {
                System.out.print("S");
                i2++;
            }
            System.out.println("S");
            i1++;
            i2 = 0;
        }
    }
}
