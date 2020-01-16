package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int score = 0;
        if (anotherCat.age == this.age || anotherCat.weight == this.weight || anotherCat.strength == this.strength) {
            score = 0;
        }
        if (anotherCat.age < this.age) {
            score += 1;
        }
        if (anotherCat.weight < this.weight) {
            score += 1;
        }
        if (anotherCat.strength < this.strength) {
            score += 1;
        }

        return score >= 2;

    }

    public static void main(String[] args) {

    }
}
