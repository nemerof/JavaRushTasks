package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<Integer> list_int = new ArrayList<Integer>();
        ArrayList<String> list_str = new ArrayList<String>();

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        int countI = 0;
        int countW = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                countI++;
            }
            else {
                countW++;
            }
        }

        String[] words = new String[countW];
        String[] numbers = new String[countI];

        countI = 0;
        countW = 0;

        for (int i=0;i<array.length;i++) {
            if (isNumber(array[i])) {
                numbers[countI]=array[i];
                countI++;
            }
            else {
                words[countW]=array[i];
                countW++;
            }
        }

        String temp;
        for (int i=0;i<numbers.length;i++) {
            for (int j=1;j<numbers.length-i;j++) {
                int a = Integer.parseInt(numbers[j-1]);
                int b = Integer.parseInt(numbers[j]);
                if(a<b) {
                    temp =numbers[j-1];
                    numbers[j-1]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }

        for (int i=0;i<words.length;i++) {
            for (int j=0;j<words.length-1;j++) {
                if (isGreaterThan(words[j],words[j+1])){
                    temp = words[j];
                    words[j]=words[j+1];
                    words[j+1]=temp;

                }
            }
        }

        countW=0;
        countI=0;

        for (int i=0;i<array.length;i++) {
            if (isNumber(array[i])) {
                array[i]=numbers[countI];
                countI++;
            }
            else {
                array[i]=words[countW];
                countW++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}