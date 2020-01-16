package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer> countOfLetters = new ArrayList<Integer>(33);

        for (int i = 0; i < 33; i ++) {
            countOfLetters.add(0);
        }

        for (int i = 0; i < list.size(); i ++) {
            for (int j = 0; j < list.get(i).length(); j ++) {
                for (int h = 0; h < alphabet.size(); h ++) {
                    if (list.get(i).toCharArray()[j] == alphabet.get(h)) {
                        int k = countOfLetters.get(h);
                        k ++;
                        countOfLetters.set(h, k);
                    }
                }
            }
        }

        for (int i = 0; i < 33; i++) {
            System.out.println(abcArray[i] + " " + countOfLetters.get(i));
        }
    }

}
