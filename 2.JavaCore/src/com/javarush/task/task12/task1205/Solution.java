package com.javarush.task.task12.task1205;

/* 
Определимся с животным
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        if (o instanceof Solution.Cow){
            return "Корова";
        }
        if (o instanceof Solution.Dog){
            return "Собака";
        }
        if (o instanceof Solution.Whale){
            return "Кит";
        }
        if (o instanceof Solution.Pig){
            return "Неизвестное животное";
        }
        return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
