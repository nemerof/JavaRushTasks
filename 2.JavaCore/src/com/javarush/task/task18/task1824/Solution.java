package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String name = rd.readLine();
            try {
                FileInputStream inputStream = new FileInputStream(name);
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(name);
                break;
            }
        }

        rd.close();
    }
}
