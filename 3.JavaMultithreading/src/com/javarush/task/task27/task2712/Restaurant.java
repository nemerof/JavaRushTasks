package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        Waiter waiter = new Waiter();

        for (int i = 0; i < 5; i ++) {
            tablets.add(new Tablet(i));
            tablets.get(i).setQueue(orderQueue);
        }

        tablets.get(0).createOrder();

        for (int i = 0; i < 2; i ++) {
            Cook cook = new Cook("ya" + i);
            cook.setQueue(orderQueue);
            cook.addObserver(waiter);
            Thread thread = new Thread(cook);
            thread.start();
        }

        Thread task = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        task.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
