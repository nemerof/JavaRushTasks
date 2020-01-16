package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> names = new HashMap<>();

        names.put("Иванов", "Вася");
        names.put("Петров", "Гена");
        names.put("Сидоров", "Лёша");
        names.put("Антонов", "Вадим");
        names.put("Вадомов", "Антон");
        names.put("Хохлов", "Дима");
        names.put("Греков", "Ваня");
        names.put("Симонов", "Никита");
        names.put("Антонов", "Денис");
        names.put("Николаев", "Лёша");

        return names;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
