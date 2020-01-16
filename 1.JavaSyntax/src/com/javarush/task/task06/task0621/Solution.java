package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpapaName = reader.readLine();
        Cat catGrandpapa = new Cat(grandpapaName, null, null);

        String grandmotherName = reader.readLine();
        Cat catGrandmother = new Cat(grandmotherName, null, null);

        String papaName = reader.readLine();
        Cat catPapa = new Cat(papaName, null, grandpapaName);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, grandmotherName, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, motherName, papaName);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, motherName, papaName);

        System.out.println(catGrandpapa);
        System.out.println(catGrandmother);
        System.out.println(catPapa);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name1;
        private String name2;
        private String name3;

        Cat(String name1, String name2, String name3){
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
        }

        @Override
        public String toString() {
            if (name2 == null && name3 == null)
                return "The cat's name is " + name1 + ", no mother, no father";
            else if (name3 == null && name2 != null)
                return "The cat's name is " + name1 + ", mother is " + name2 + ", no father";
            else if (name2 == null && name3 != null)
                return "The cat's name is " + name1 + ", no mother, father is " + name3;
            else{
                return "The cat's name is " + name1 + ", mother is " + name2 + ", father is " + name3;
            }
        }
    }

}
