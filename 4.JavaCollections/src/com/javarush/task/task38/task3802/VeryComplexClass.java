package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileOutputStream;
import java.io.OutputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        OutputStream os = new FileOutputStream("");
    }

    public static void main(String[] args) {

    }
}
