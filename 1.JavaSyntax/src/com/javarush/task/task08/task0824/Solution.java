package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        Human child1 = new Human("dima", true, 7, list);
        Human child2 = new Human("masha", false, 8, list);
        Human child3 = new Human("misha", true, 9, list);
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human father = new Human("alex", true, 34, children);
        Human mother = new Human("olga", false, 37, children);
        ArrayList<Human> parents1 = new ArrayList<Human>();
        parents1.add(father);
        ArrayList<Human> parents2 = new ArrayList<Human>();
        parents2.add(mother);
        Human grandP1 = new Human("den", true, 60, parents1);
        Human grandP2 = new Human("andrey", true, 61, parents2);
        Human grandM1 = new Human("sasha", false, 62, parents1);
        Human grandM2 = new Human("kristina", false, 63, parents2);
        System.out.println(grandP1.toString());
        System.out.println(grandP2.toString());
        System.out.println(grandM1.toString());
        System.out.println(grandM2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human extends ArrayList<Human> {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
