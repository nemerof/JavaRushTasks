package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            list.add(reader.readLine());
        }
        list.remove(2);
        Collections.reverse(list);
        for (int i = 0; i < 4; i++){
            System.out.println(list.get(i));
        }
    }
}


