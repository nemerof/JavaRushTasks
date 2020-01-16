package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (fReader.ready()) {
            int a = Integer.parseInt(fReader.readLine());
            if (a % 2 == 0) list.add(a);
        }

        fReader.close();
        reader.close();

        Collections.sort(list);

        for (int number : list) {
            System.out.println(number);
        }
    }
}
