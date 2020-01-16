package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        int count = 0;
        int index = 0;

        if (string == null) {
            throw new TooShortStringException();
        }

        for (int i = 0; i < string.length(); i ++) {
            if (string.charAt(i) == ' ') {
                count ++;
            }
            if (count == 4) {
                index = i;
            }
        }

        if (count < 4) {
            throw new TooShortStringException();
        }

        int firstIndex = string.indexOf(' ');
        String result = string.substring(firstIndex + 1, index + 1);
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
