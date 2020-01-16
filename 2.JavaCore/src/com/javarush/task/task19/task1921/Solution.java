package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));
        String line;

        while ((line = rd.readLine()) != null) {
            String[] stringArray = line.split(" ");
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < stringArray.length - 3; i++) {
                if (i == stringArray.length - 4) {
                    name.append(stringArray[i]);
                } else {
                    name.append(stringArray[i]).append(" ");
                }
            }

            int year = Integer.parseInt(stringArray[stringArray.length - 1]);
            int month = Integer.parseInt(stringArray[stringArray.length - 2]) - 1;
            int day = Integer.parseInt(stringArray[stringArray.length - 3]);
            Date birthDay = new GregorianCalendar(year, month, day).getTime();
            PEOPLE.add(new Person(name.toString(), birthDay));
        }

        rd.close();
    }
}
