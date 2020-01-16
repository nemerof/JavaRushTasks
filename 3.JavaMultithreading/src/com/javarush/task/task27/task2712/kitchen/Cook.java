package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private boolean busy;
    private String name;
    private boolean stopped = false;
    private boolean caught = false;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime()*60, order.getDishes()));
        setChanged();
        notifyObservers(order);
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
        }
        busy = false;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (!stopped){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if (queue.peek()!=null){
                if (!this.isBusy()) {
                    try {
                        Order order = queue.take();
                        if (order != null){
                            startCookingOrder(order);
                        }
                    }
                    catch (InterruptedException e){caught = true;}
                }
            }
            if (caught&&queue.isEmpty()) stopped=true;
        }
    }
}
