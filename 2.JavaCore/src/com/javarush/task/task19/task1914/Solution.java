package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        String[] chars = result.split(" ");
        switch (chars[1]) {
            case("+"):
                System.out.print(chars[0]);
                System.out.print(" + ");
                System.out.print(chars[2]);
                System.out.print(" = ");
                System.out.print(Integer.parseInt(chars[0]) + Integer.parseInt(chars[2]));
                break;
            case ("-"):
                System.out.print(chars[0]);
                System.out.print(" - ");
                System.out.print(chars[2]);
                System.out.print(" = ");
                System.out.print(Integer.parseInt(chars[0]) - Integer.parseInt(chars[2]));
                break;
            case ("*"):
                System.out.print(chars[0]);
                System.out.print(" * ");
                System.out.print(chars[2]);
                System.out.print(" = ");
                System.out.print(Integer.parseInt(chars[0]) * Integer.parseInt(chars[2]));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

