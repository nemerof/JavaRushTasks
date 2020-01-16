package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(rd.readLine());
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            set.add(data);
        }

        for (int elem : set) {
            list.add(elem);
        }

        Collections.sort(list);

        for (int elem : list) {
            System.out.print(elem + " ");
        }
        inputStream.close();
        rd.close();
    }
}
