package com.javarush.task.task06.task0610;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return rd.readLine();

    }

    public static int readInt() throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(rd.readLine());

    }

    public static double readDouble() throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(rd.readLine());

    }

    public static boolean readBoolean() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        return Boolean.parseBoolean(rd.readLine());
    }

    public static void main(String[] args) throws Exception {
    }
}
