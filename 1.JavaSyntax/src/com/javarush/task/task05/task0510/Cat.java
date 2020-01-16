package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;
    public void initialize(String name){
        this.name = name;
        this.age = 1;
        this.weight = 7;
        this.color = "white";
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "white";
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 10;
    }
    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = 7;
    }
    public void initialize(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 7;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.initialize("Vaska", 12);
        int weight = cat1.weight;
        System.out.println(weight);
    }
}
