package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        Map<Integer, Integer> listOfChars = new HashMap<>();

        List<Integer> listForOutput = new ArrayList<>();

        Integer tmpInt;
        Integer maxFreq = 0;

        while (fileInputStream.available() > 0) {
            tmpInt = fileInputStream.read();
            if (listOfChars.containsKey(tmpInt)) {
                Integer tmp = (Integer) listOfChars.get(tmpInt) + 1;

                listOfChars.put(tmpInt, tmp);

                if (tmp > maxFreq) {
                    maxFreq = tmp;
                }
            }
            else {
                listOfChars.put(tmpInt, 1);
            }
        }

        fileInputStream.close();
        for (Map.Entry<Integer, Integer> pair: listOfChars.entrySet()) {
            if (pair.getValue().equals(maxFreq)) {
                if (!listForOutput.contains(pair.getValue())) {
                    listForOutput.add(pair.getKey());
                }
            }
        }

        System.out.print(listForOutput.get(0));

        if (listForOutput.size() > 2) {
            for (int i = 1; i < listForOutput.size(); i++) {
                System.out.print(" " + listForOutput.get(i));
            }
        }

    }

}
