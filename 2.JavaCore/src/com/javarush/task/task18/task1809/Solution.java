package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(rd.readLine());
        FileOutputStream outputStream = new FileOutputStream(rd.readLine());

        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        Collections.reverse(list);

        for (int elem : list) {
            outputStream.write(elem);
        }

        inputStream.close();
        outputStream.close();
    }
}
