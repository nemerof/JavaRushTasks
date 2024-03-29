package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        Movie movie;

        while (true) {
            key = reader.readLine();

            if (key.equals("thriller")) {
                movie = MovieFactory.getMovie("thriller");
            }
            else if (key.equals("cartoon")) {
                movie = MovieFactory.getMovie("cartoon");
            }
            else if (key.equals("soapOpera")) {
                movie = MovieFactory.getMovie("soapOpera");
            }
            else {
                movie = MovieFactory.getMovie(key);
                break;
            }

            System.out.println(movie.getClass().getSimpleName());
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            if (key.equals("cartoon")) {
                movie = new Cartoon();
            }
            else if (key.equals("thriller")) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
