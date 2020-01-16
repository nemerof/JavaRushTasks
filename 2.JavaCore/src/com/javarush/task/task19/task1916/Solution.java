package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = rd.readLine();
        String secondFile = rd.readLine();
        rd.close();

        BufferedReader rd1 = new BufferedReader(new FileReader(firstFile));
        BufferedReader rd2 = new BufferedReader(new FileReader(secondFile));

        ArrayList<String> stringsFile1 = new ArrayList<>();
        ArrayList<String> stringsFile2 = new ArrayList<>();
        while (rd1.ready()) {
            stringsFile1.add(rd1.readLine());
        }
        while (rd2.ready()) {
            stringsFile2.add(rd2.readLine());
        }

        rd1.close();
        rd2.close();

        int f1 = 0;
        int f2 = 0;

        while (f1 < stringsFile1.size() && f2 < stringsFile2.size()) {
            if (stringsFile1.get(f1).equals(stringsFile2.get(f2))) {
                linesAddSAME(stringsFile1.get(f1));
                f1++;
                f2++;
            }
            else if (stringsFile1.size() > f1 + 1 && stringsFile1.get(f1 + 1).equals(stringsFile2.get(f2))) {
                linesAddREMOVED(stringsFile1.get(f1));
                f1++;
            }
            else if (stringsFile2.size() > f2 + 1 && stringsFile2.get(f2 + 1).equals(stringsFile1.get(f1))) {
                linesAddADDED(stringsFile2.get(f2));
                f2++;
            }

        }
        if (f1 < stringsFile1.size()) {
            linesAddREMOVED(stringsFile1.get(f1));
        }
        if (f2 < stringsFile2.size()) {
            linesAddADDED(stringsFile2.get(f2));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static void linesAddSAME (String line) {
        lines.add(new LineItem(Type.SAME, line));
    }

    public static void linesAddADDED (String line) {
        lines.add(new LineItem(Type.ADDED, line));
    }

    public static void linesAddREMOVED (String line) {
        lines.add(new LineItem(Type.REMOVED, line));
    }
}
