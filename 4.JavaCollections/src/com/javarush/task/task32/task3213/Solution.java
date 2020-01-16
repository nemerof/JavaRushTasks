package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        char[] array = new char[0];
        if (reader != null) {
            BufferedReader rd = new BufferedReader(reader);
            array = rd.readLine().toCharArray();
            for (int i = 0; i < array.length; i ++) {
                array[i] = (char) (((int) array[i]) + key);
            }
        }
        return new String(array);
    }
}
