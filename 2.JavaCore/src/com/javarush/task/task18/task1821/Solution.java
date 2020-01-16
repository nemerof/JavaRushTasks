package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(args[0]);

        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        for (int elem : list) {
            if (!map.containsKey((int) elem)) {
                map.put((int) elem, 1);
            } else {
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if ((int) elem == pair.getKey()) {
                        int value = pair.getValue();
                        map.replace(pair.getKey(), ++value);
                    }
                }
            }
        }


        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            System.out.println((char)(int) pair.getKey() + " " + pair.getValue());
        }

        inputStream.close();

    }
}
