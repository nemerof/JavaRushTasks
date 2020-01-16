package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> listVowel = new ArrayList<Character>();
        String word = reader.readLine();
        char[] wordArray = word.toCharArray();
        ArrayList<Character> listNoVowel = new ArrayList<Character>();

        for (int i = 0; i < wordArray.length; i ++) {
            for (int j = 0; j < vowels.length; j ++) {
                if (wordArray[i] == vowels[j]) {
                    listVowel.add(wordArray[i]);
                    break;
                }
            }
            if (!String.valueOf(wordArray[i]).equals(" ")){
                    listNoVowel.add(wordArray[i]);
            }
        }
        listNoVowel.removeAll(listVowel);

        for (Character vowel : listVowel) {
            System.out.print(vowel + " ");
        }
        System.out.println("");
        for (Character noVowel : listNoVowel) {
            System.out.print(noVowel + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}