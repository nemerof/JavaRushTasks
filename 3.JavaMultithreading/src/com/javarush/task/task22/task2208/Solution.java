package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("age", null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (!(value == null)) {
                builder.append(key);
                builder.append(" = '");
                builder.append(value).append("' and ");
            }
        }

        try {
            builder.replace(builder.length() - 5, builder.length(),"");
        } catch (StringIndexOutOfBoundsException e) {
        }

        return builder.toString();
    }
}
