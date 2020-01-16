package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Сталлоне", "Сильвестр");
        map.put("Мориконе", "Энио");
        map.put("Вивальди","Антонио");
        map.put("Белучи", "Антонио");
        map.put("Гудини", "Антонио");
        map.put("Верди", "Джузеппе");
        map.put("Марацци", "Бруно");
        map.put("Корлионе", "Вито");
        map.put("Брацци", "Люка");
        map.put("Страдивари", "Антонио");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> listValue = new ArrayList<>(map.values());
        for (int i=0 ; i<listValue.size(); i++){
            String s = listValue.get(i);
            for (int j = i + 1; j<listValue.size(); j++){
                if (s.equals(listValue.get(j)))
                    removeItemFromMapByValue(map,listValue.get(j));
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }
}
