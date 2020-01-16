package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        int data;
        int encoder = 5;

        switch (args[0]){
            case "-e":
                while (inputStream.available() > 0) {
                    data = inputStream.read();
                    outputStream.write(data - encoder);
                }
            case "-d":
                while (inputStream.available() > 0) {
                    data = inputStream.read();
                    outputStream.write(data + encoder);
                }
        }

        inputStream.close();
        outputStream.close();
    }

}
