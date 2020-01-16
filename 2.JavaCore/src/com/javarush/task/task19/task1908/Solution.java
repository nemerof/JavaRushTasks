package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileInput = rd.readLine();
        String fileOutput = rd.readLine();
        rd.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOutput));

        ArrayList<String[]> list = new ArrayList<>();
        ArrayList<String> finalList = new ArrayList<>();

        while (fileReader.ready()) {
            list.add(fileReader.readLine().split(" "));
        }

        for (String[] arrays : list) {
            for (String elem : arrays) {
                if (Solution.IsDigitsOnly(elem)) {
                    finalList.add(elem);
                }
            }
        }

        for (String elem : finalList) {
            fileWriter.write(elem + " ");
        }

        fileReader.close();
        fileWriter.close();
    }

    public static boolean IsDigitsOnly(String str)
    {
        for (char c : str.toCharArray())
        {
            if (c < '0' || c > '9')
                return false;
        }

        return true;
    }
}
