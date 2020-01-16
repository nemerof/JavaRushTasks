package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String first = rd.readLine();
        String second = rd.readLine();
        FileInputStream inputStream = new FileInputStream(first);
        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            list.add(data);
        }
        inputStream.close();

        FileInputStream inputStream1 = new FileInputStream(second);
        FileOutputStream outputStream = new FileOutputStream(first);

        while (inputStream1.available() > 0) {
            int data  = inputStream1.read();
            outputStream.write(data);
        }
        for (int elem : list ) {
            outputStream.write(elem);
        }


        inputStream1.close();
        outputStream.close();
    }
}
