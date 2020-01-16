package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = rd.readLine();
        String outputFile = rd.readLine();
        rd.close();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        while (reader.ready()) {
            String line = reader.readLine().replaceAll("[\\p{Punct}\\n]", "");
            writer.write(line);
        }

        reader.close();
        writer.close();
    }
}
