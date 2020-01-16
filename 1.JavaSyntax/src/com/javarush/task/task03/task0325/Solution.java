package com.javarush.task.task03.task0325;

import java.io.*;
import java.nio.Buffer;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String money = reader.readLine();

        System.out.println("Я буду зарабатывать $" + money + " в час");

    }
}
