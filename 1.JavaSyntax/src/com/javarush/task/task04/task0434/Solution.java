package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 1;
        while (i1 < 11){
            while (i2 < 11) {
                System.out.print(i1 * i2 + " ");
                i2++;
            }
            System.out.println("");
            i1++;
            i2 = 1;
        }

    }
}
