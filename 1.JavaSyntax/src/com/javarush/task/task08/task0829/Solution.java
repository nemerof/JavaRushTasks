package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<String, String>();

        String city = reader.readLine();

        while (true) {
            map.put(city, reader.readLine());
            city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
        }

        String forFind = reader.readLine();

        System.out.println(map.get(forFind));
    }
}
