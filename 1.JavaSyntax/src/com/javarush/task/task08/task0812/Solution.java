package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listOfCounts = new ArrayList<Integer>();

        int count = 1;

        for (int i = 0; i < 10; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < 9; i++){
            int beginOfSeq = list.get(i);
            if (beginOfSeq == list.get(i + 1)){
                count += 1;
                if (i == 8) {
                    listOfCounts.add(count);
                }
            }
            else{
                beginOfSeq = list.get(i + 1);
                listOfCounts.add(count);
                count = 1;
            }
        }

        System.out.println(Collections.max(listOfCounts));

    }
}