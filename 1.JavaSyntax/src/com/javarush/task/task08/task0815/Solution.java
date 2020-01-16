package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Grock", "Tor");
        map.put("Grock1", "Grock");
        map.put("Tor", "Tor");
        map.put("Tor1", "Grock");
        map.put("Grock2", "Man");
        map.put("Man", "Tor");
        map.put("Woman", "Tor");
        map.put("Grock3", "Woman");
        map.put("Man1", "Woman");
        map.put("Woman1", "Man");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue() == name){
                count ++;
            }
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey() == lastName){
                count ++;
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
