package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> mySet = new HashSet<String>();
        mySet.add("арбуз");
        mySet.add("банан");
        mySet.add("вишня");
        mySet.add("груша");
        mySet.add("дыня");
        mySet.add("ежевика");
        mySet.add("женьшень");
        mySet.add("земляника");
        mySet.add("ирис");
        mySet.add("картофель");

        for (String text: mySet) {
            System.out.println(text);
        }


    }
}
