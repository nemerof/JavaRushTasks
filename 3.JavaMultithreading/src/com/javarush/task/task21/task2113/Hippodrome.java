package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i ++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i ++) {
            System.out.println();
        }
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);

        for (Horse horse : horses) {
            if (winner.distance < horse.distance) {
                winner = horse;
            }
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " +  getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Sasha", 3, 0));
        game.getHorses().add(new Horse("Eugen", 3, 0));
        game.getHorses().add(new Horse("Dimon", 3, 0));
        game.run();
        game.printWinner();
    }
}
