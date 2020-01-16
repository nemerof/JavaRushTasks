package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] info = this.fileScanner.nextLine().split(" ");

            String lastName = info[0];
            String middleName = info[2];
            String firstName = info[1];

            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            String birth = info[3] + " " + info[4] + " " + info[5];
            Date birthDate = sdf.parse(birth);


            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
