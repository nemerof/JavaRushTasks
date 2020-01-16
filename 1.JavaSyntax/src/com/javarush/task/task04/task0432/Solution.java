package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String word = rd.readLine();
        int amount = Integer.parseInt(rd.readLine());
        while (amount >0){
            System.out.println(word);
            amount--;
        }

    }
}
