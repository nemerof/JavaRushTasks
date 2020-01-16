package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        ArrayList<String> list = new ArrayList<>();

        while (reader.ready()) {
            String elem = reader.readLine();
            list.add(elem);
        }

        for (String elem : list) {
            elem = elem.replace(".", "!");
            writer.write(elem + " ");
        }

        reader.close();
        writer.close();
    }
}
