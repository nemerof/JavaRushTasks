package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(array);
        System.setOut(printStream);
        testString.printSomething();
        String result = array.toString();
        System.setOut(consoleStream);
        FileOutputStream outputStream = new FileOutputStream(rd.readLine());
        System.out.println(result);
        char[] chars = result.toCharArray();
        for (char elem : chars) {
            outputStream.write((int) elem);
        }

        rd.close();
        outputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

