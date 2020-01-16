package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> nameOfFiles = new ArrayList<>();

        while (true) {
            String name = rd.readLine();
            if (name.equals("end")) {
                break;
            } else {
                nameOfFiles.add(name);
            }
        }

        rd.close();

        Map<Integer, String> map = new TreeMap<Integer, String>();

        for (String elem : nameOfFiles) {
            String lastIndex = elem.substring(elem.lastIndexOf(".part") + 5, elem.length());
            map.put(Integer.parseInt(lastIndex), elem);
        }

        nameOfFiles = new ArrayList<>();

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            nameOfFiles.add(pair.getValue());
        }


        FileOutputStream outputStream = new FileOutputStream(nameOfFiles.get(0).substring(0, nameOfFiles.get(0).lastIndexOf(".part")));
        FileInputStream inputStream;
        byte[] buffer;
        int data;

        for (String elem : nameOfFiles) {
            inputStream = new FileInputStream(elem);
            while (true) {
                buffer = new byte[1000];
                if (inputStream.available() > 0) {
                    data = inputStream.read(buffer);
                    outputStream.write(buffer, 0, data);
                } else {
                    break;
                }
            }
            inputStream.close();
        }

        outputStream.close();
    }
}
