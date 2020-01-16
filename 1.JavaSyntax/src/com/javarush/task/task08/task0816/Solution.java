package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", df.parse("JULY 6 1946"));
        map.put("Schwarzenegger", df.parse("JULY 30 1947"));
        map.put("Lundgren", df.parse("NOVEMBER 3 1957"));
        map.put("Statham", df.parse("JULY 26 1967"));
        map.put("Willis", df.parse("MARCH 19 1955"));
        map.put("Gibson", df.parse("JANUARY 3 1956"));
        map.put("Cruise", df.parse("JULY 3 1962"));
        map.put("Chan", df.parse("APRIL 7 1954"));
        map.put("Norris", df.parse("MARCH 10 1940"));
        map.put("Ford", df.parse("JULY 13 1942"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            int mounth = value.getMonth();
            if (mounth == 5 || mounth == 6 || mounth == 7) iterator.remove();
        }

    }

    public static void main(String[] args) {

    }
}
