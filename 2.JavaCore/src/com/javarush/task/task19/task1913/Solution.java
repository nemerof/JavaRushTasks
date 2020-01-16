package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(array);
        System.setOut(printStream);
        testString.printSomething();
        String result = array.toString();
        System.setOut(consoleStream);
        char[] strings = result.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (char c : strings) {
            if (c > '0' && c < '9') {
                list.add(c);
            }
        }

        list.forEach(System.out::print);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
