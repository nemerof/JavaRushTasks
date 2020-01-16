package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list =  new ArrayList<String>();
        list.add("qwdqwdw");
        list.add("qwdqffwdw");
        list.add("qwdqwfffdw");
        list.add("qwdqffffwdw");
        list.add("qwdqfwdw");
        System.out.println(list.size());
        for (int i = 0; i < 5; i++){
            System.out.println(list.get(i));
        }
    }
}
