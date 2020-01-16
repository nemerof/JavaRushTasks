package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws CorruptedDataException, IOException {
        String main = rd.readLine();
        String removal = rd.readLine();
        BufferedReader rd1 = new BufferedReader(new InputStreamReader(new FileInputStream(main)));
        String line;
        while ((line = rd1.readLine()) != null) {
            allLines.add(line);
        }
        rd1.close();
        BufferedReader rd2 = new BufferedReader(new InputStreamReader(new FileInputStream(removal)));
        String line1;
        while ((line1 = rd2.readLine()) != null) {
            forRemoveLines.add(line1);
        }
        rd2.close();
        Solution solution = new Solution();
        solution.joinData();

    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
