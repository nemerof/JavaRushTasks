package com.javarush.task.task05.task0529;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;

        while (true){
            String word = rd.readLine();
            if (word.equals("сумма")){
                break;
            }
            summ += Integer.parseInt(word);
        }
        System.out.println(summ);
    }
}
