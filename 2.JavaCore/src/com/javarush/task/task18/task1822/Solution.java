package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rd1 = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine())));

        String line;
        ArrayList<String> list = new ArrayList<>();

        while((line = rd1.readLine()) != null) {
            list.add(line);
        }

        for (String elem : list) {
            String[] newArray = elem.split(" ");
            if (newArray[0].equals(String.valueOf(args[0]))) {
                for (String product : newArray) {
                    System.out.print(product + " ");
                }
            }
        }

        rd.close();
        rd1.close();
    }
}
