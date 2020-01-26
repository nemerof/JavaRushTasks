package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startTime = new Date();
        strings.forEach(str -> ids.add(shortener.getId(str)));
        Date endTime = new Date();
        return endTime.getTime() - startTime.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startTime = new Date();
        ids.forEach(id -> strings.add(shortener.getString(id)));
        Date endTime = new Date();
        return endTime.getTime() - startTime.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids = new HashSet<>();

        Long timeWhithHashMapIds= getTimeToGetIds(shortener1, origStrings, ids);
        Long timeWhithHashMapStrings = getTimeToGetStrings(shortener1,ids,new HashSet<String>());

        Set<Long> idsBi = new HashSet<>();
        Long timeWhithHashBiMapIds = getTimeToGetIds(shortener2, origStrings,idsBi);
        Long timeWhithHashBiMapStrings = getTimeToGetStrings(shortener2,idsBi,new HashSet<String>());


        Assert.assertTrue(timeWhithHashMapIds > timeWhithHashBiMapIds);
        Assert.assertEquals(timeWhithHashMapStrings, timeWhithHashBiMapStrings,30);
    }
}
