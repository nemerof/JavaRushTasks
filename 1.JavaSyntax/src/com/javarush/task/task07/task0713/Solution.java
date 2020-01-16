package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i ++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list23 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i ++){
            Integer x = list.get(i);
            if (x % 3 == 0){
                list3.add(list.get(i));
            }
            if (x % 2 == 0){
                list2.add(list.get(i));
            }
            if (x % 2 != 0 && x % 3 != 0) {
                list23.add(list.get(i));
            }
        }
        printList(list3);
        printList(list2);
        printList(list23);
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
