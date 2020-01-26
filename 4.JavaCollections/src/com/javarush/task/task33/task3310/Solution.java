package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.DualHashBidiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000);
        testStrategy(new HashBiMapStorageStrategy(), 10_000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String string : strings) {
            set.add(shortener.getId(string));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long key : keys) {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i ++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date begin = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date end = new Date();
        System.out.println("Тест айдишников: " + (end.getTime() - begin.getTime()) + "ms");
        begin = new Date();
        Set<String> newStrings = getStrings(shortener, ids);
        end = new Date();
        System.out.println("Тест айдишников назад(useless): " + (end.getTime() - begin.getTime()) + "ms");
        if (newStrings.containsAll(strings)) {
            System.out.println("Тест пройден.");
        } else {
            System.out.println("Тест не пройден.");
        }
    }
}
