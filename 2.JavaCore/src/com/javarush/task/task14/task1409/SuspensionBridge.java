package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    final int cars = 200;

    @Override
    public int getCarsCount() {
        return cars;
    }
}
