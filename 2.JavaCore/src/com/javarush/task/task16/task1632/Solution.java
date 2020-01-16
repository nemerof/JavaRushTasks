package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
    }

    static {
        threads.add(new Thread(new InfinityThread()));
        threads.add(new Thread(new ThreadWithException()));
        threads.add(new Thread(new HappyThread()));
        threads.add(new ThreadUsingInterface());
        threads.add(new Thread(new ReadingThread()));
    }

    static class InfinityThread extends Thread {

        @Override
        public void run() {
            while (true) {}
        }
    }

    static class ThreadWithException extends Thread {

        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    static class HappyThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class ThreadUsingInterface extends Thread implements Message {

        @Override
        public void run() {
            while(!this.isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    static class ReadingThread extends Thread {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String input;
        int inputNumber;

        @Override
        public void run() {
            while (true) {
                try {
                    input = rd.readLine();
                    if (input.equals("N")) {
                        System.out.println(sum);
                        Thread.currentThread().interrupt();
                    }
                    inputNumber = Integer.parseInt(input);
                    sum += inputNumber;

                } catch (IOException e) {
                }
            }
        }
    }
}