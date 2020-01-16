package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private int height;
        private int weight;
        private char sex;
        private Human mother;

        public Human(String name) {
            this.name = name;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(int age, int height) {
            this.age = age;
            this.height = height;
        }

        public Human(int age, int height, int weight) {
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, int age, int height, int weight, char sex, Human mother) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.sex = sex;
            this.mother = mother;
        }

        public Human(int age, Human mother) {
            this.age = age;
            this.mother = mother;
        }

        public Human(String name, Human mother) {
            this.name = name;
            this.mother = mother;
        }

        public Human(char sex) {
            this.sex = sex;
        }

        public Human(char sex, Human mother) {
            this.sex = sex;
            this.mother = mother;
        }

        public Human(String name, char sex) {
            this.name = name;
            this.sex = sex;
        }
    }

}
