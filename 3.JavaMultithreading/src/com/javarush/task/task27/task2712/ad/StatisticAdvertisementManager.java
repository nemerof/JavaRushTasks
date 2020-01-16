package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {}

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public List<Advertisement> getActiveVideos() {
        List<Advertisement> list = new ArrayList<>();
        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getHits()>0)
                list.add(storage.list().get(i));
        }
        return list;
    }

    public List<Advertisement> getArchivedVideos() {
        List<Advertisement> list = new ArrayList<>();
        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getHits()<=0)
                list.add(storage.list().get(i));
        }
        return list;
    }
}
