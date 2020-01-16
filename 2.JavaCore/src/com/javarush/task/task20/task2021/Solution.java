package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void readObject(ObjectInputStream out) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }

        private void writeObject(ObjectOutputStream in) throws IOException, InterruptedException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
