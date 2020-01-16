package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));
        BufferedWriter wr = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> list = new ArrayList<>();

        while (rd.ready()) {
            String line = rd.readLine();
            String[] array = line.split(" ");
            for (String elem : array) {
                if (elem.length() > 6) {
                    list.add(elem);
                    list.add(",");
                }
            }
        }

        list.remove(list.size() - 1);
        for (String elem : list ) {
            wr.write(elem);
        }

        rd.close();
        wr.close();
    }
}
