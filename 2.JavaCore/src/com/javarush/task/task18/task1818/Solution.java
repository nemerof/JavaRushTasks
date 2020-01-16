package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(rd.readLine());
        FileInputStream inputStream2 = new FileInputStream(rd.readLine());
        FileInputStream inputStream3 = new FileInputStream(rd.readLine());
        rd.close();

        while (inputStream2.available() > 0) {
            int data = inputStream2.read();
            outputStream.write(data);
        }

        while (inputStream3.available() > 0) {
            int data = inputStream3.read();
            outputStream.write(data);
        }

        outputStream.close();
        inputStream2.close();
        inputStream3.close();
    }
}
