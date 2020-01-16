package com.javarush.task.task10.task1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Поправочки нужны
*/

public class Solution {
    static HashMap<Integer, String> map = new HashMap<Integer, String>();
    static Integer index;
    static String name;

    /*public Solution() {
        this.map = new HashMap<Integer, String>();
        map.put(index, name);
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 2; i++) {
            int index = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            map.put(index, name);
        }

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            index = pair.getKey();
            name = pair.getValue();
            System.out.println("Id=" + index + " Name=" + name);
        }
    }
}
