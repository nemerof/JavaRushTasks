package com.javarush.task.task19.task1911;

/* 
Ридер обертка
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
        StringBuilder stringBuilder = new StringBuilder(result);
        String string = stringBuilder.toString().toUpperCase();
        System.out.println(string);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
