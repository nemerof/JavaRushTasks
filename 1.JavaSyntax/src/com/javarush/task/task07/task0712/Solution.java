package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            list.add(reader.readLine());
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < 10; i++){
            if (list.get(max).length() < list.get(i).length()){
                max = i;
            }
            if (list.get(min).length() > list.get(i).length()){
                min = i;
            }
        }
        for (int i = 0; i < 10; i++){
            if (list.get(max).length() == list.get(i).length()){
                max = i;
                break;
            }
        }
        for (int i = 0; i < 10; i++){
            if (list.get(min).length() == list.get(i).length()){
                min = i;
                break;
            }
        }
        if (max > min){
            System.out.println(list.get(min));
        }
        else {
            System.out.println(list.get(max));
        }
    }
}
