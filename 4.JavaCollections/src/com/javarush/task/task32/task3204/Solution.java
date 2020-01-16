package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        char[] array = new char[8];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        array[0] = (char) (((int) (Math.random() * 25) + 65));
        baos.write(String.valueOf(array[0]).getBytes());
        array[1] = (char) (((int) (Math.random() * 9) + 48));
        baos.write(String.valueOf(array[1]).getBytes());
        for (int i = 2; i < 8; i ++) {
            int randomI = (int) (Math.random() * 25);
            array[i] = (char) (randomI + 97);
            baos.write(String.valueOf(array[i]).getBytes());
        }

        return baos;
    }
}