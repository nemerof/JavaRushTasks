package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        for (Object cat : cats) {
            cats.remove(cat);
            break;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> set = new HashSet<Cat>();

        for (int i = 0; i < 3; i ++) {
            set.add(new Cat());
        }

        return set;
    }

    public static void printCats(Set<Cat> cats) {
        for (Object cat : cats) {
            System.out.println(cat);
        }
    }

    public static class Cat {

    }
}
