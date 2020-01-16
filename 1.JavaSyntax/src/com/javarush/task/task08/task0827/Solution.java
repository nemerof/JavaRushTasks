package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2014"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date beginDate = format.parse(date);

        Date startYear = new Date();
        startYear.setDate(1);
        startYear.setMonth(0);
        startYear.setYear(beginDate.getYear());
        startYear.setMinutes(0);
        startYear.setHours(0);
        startYear.setSeconds(0);

        if (((beginDate.getTime() - startYear.getTime())/(1000*60*60*24))%2==0)
            return false;
        else
            return true;
    }
}
