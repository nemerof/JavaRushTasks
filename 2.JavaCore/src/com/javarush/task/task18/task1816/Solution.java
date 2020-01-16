package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String line;
        int count = 0;
        ArrayList<Character> list = new ArrayList<>();

        while ((line = rd.readLine()) != null) {
            char[] array = line.toLowerCase().toCharArray();
            for (char elem : array) {
                list.add(elem);
            }
        }

        for (char elem : list) {
            if ((int) elem >= 97 && (int) elem <= 122) {
                count++;
            }
        }

        rd.close();
        System.out.println(count);
    }
}
