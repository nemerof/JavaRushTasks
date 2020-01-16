package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        final String OLD_FORMAT = "dd/MM/yyyy";
        final String NEW_FORMAT = "dd-MMM-yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);

        if (args[0].equals("-c")) {
            try {
                Date d = sdf.parse(args[3]);
                sdf.applyPattern(NEW_FORMAT);
                String newDateString = sdf.format(d);
                Date date = new Date(newDateString);
                allPeople.add(args[2].equals("м") ? Person.createMale(args[1], date) : Person.createFemale(args[1], date));
                System.out.println(allPeople.size() - 1);
            } catch (ParseException e) {
            }
        }
        else if (args[0].equals("-u")) {
            try {
                Date d = sdf.parse(args[4]);
                sdf.applyPattern(NEW_FORMAT);
                String newDateString = sdf.format(d);
                Date date = new Date(newDateString);
                allPeople.remove(Integer.parseInt(args[1]));
                allPeople.add(Integer.parseInt(args[1]), args[3].equals("м") ? Person.createMale(args[2], date) : Person.createFemale(args[2], date));
            } catch(ParseException e) {
            }
        }
        else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDate(null);
            person.setName(null);
            person.setSex(null);
        }
        else {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.print(person.getName() + " ");
            if (person.getSex().equals(Sex.FEMALE)) {
                System.out.print("ж" + " ");
            } else {
                System.out.print("м" + " ");
            }

            sdf.applyPattern(NEW_FORMAT);
            String newDateString = sdf.format(person.getBirthDate());
            System.out.print(newDateString);
        }

    }
}
