package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createFemale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        try {
            switch (args[0]) {
                case ("-c"):
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                            Person person = null;
                            String name = args[i];
                            String sex = args[i + 1];
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            Date date = format.parse(args[i + 2]);
                            person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                    break;
                case ("-u"):
                synchronized (allPeople) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i += 4)
                    {
                        String id = args[i];
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        String bd = args[i + 3];
                        Person person = allPeople.get(Integer.parseInt(id));
                        person.setName(name);
                        try
                        {
                            person.setBirthDate(format.parse(bd));
                        }
                        catch (ParseException e)
                        {
                            System.out.println("Нет - хреновая дата");
                        }
                        if (sex.equals("м")) person.setSex(Sex.MALE);
                        if (sex.equals("ж")) person.setSex(Sex.FEMALE);
                        allPeople.set(Integer.parseInt(id), person);
                    }
                }
                break;
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {

                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                }
                break;
            case ("-i"):
                synchronized (allPeople)

                {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        System.out.print(allPeople.get(id).getName() + " ");
                        System.out.print(allPeople.get(id).getSex().equals(Sex.MALE) ? "м " : "ж ");
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(format.format(allPeople.get(id).getBirthDate()));
                    }
                }
                break;
        }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}