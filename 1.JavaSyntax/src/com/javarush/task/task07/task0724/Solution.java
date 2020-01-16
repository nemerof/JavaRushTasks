package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human man1 = new Human("dima", true,12);
        Human man2 = new Human("dimaa", true,2);
        Human man3 = new Human("daima", false,1);
        Human man4 = new Human("diama", true,123);
        Human man5 = new Human("diama", true,123, man1, man2);
        Human man6 = new Human("diama", true,123, man1, man2);
        Human man7 = new Human("diama", true,123, man1, man2);
        Human man8 = new Human("diama", true,123, man1, man2);
        Human man9 = new Human("diama", true,123, man1, man2);

        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(man3.toString());
        System.out.println(man4.toString());
        System.out.println(man5.toString());
        System.out.println(man6.toString());
        System.out.println(man7.toString());
        System.out.println(man8.toString());
        System.out.println(man9.toString());

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}