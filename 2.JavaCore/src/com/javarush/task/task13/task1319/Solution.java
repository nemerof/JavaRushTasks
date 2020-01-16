package com.javarush.task.task13.task1319;

import java.io.*;

/*
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        while (true){
            String s = reader.readLine();
            if(!s.equals("exit")){
                writer.write(s);
                writer.newLine();
            }
            else {
                writer.write(s);
                break;
            }
        }
        reader.close();
        writer.close();
    }
}
