package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return Factory.class;
    }

    public static void main(String[] args) {

    }

    public static class Factory {
        public static Throwable createException(Enum type) {
            if (type == null)
                return new IllegalArgumentException();
            String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");

            if (type instanceof ApplicationExceptionMessage)
                return new Exception(message);

            if (type instanceof DatabaseExceptionMessage)
                return new RuntimeException(message);

            if (type instanceof UserExceptionMessage)
                return new Error(message);

            return new IllegalArgumentException();
        }
    }
}