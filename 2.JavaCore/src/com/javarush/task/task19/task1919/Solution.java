package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<String, Double> map = new TreeMap<>();
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));
        String line;

        while ((line = rd.readLine()) != null) {
           String name = line.split(" ")[0];
           double salary = Double.parseDouble(line.split(" ")[1]);
           if (map.containsKey(name)) {
               map.replace(name, map.get(name) + salary);
           } else {
               map.put(name, salary);
           }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        rd.close();

    }
}
