package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<String, Double> map = new HashMap<>();
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

        Map.Entry<String,Double> entry = map.entrySet().iterator().next();
        double max = entry.getValue();

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }

        rd.close();
    }
}
