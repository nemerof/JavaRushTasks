package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>();
        for (T o : elements) {
            list.add(o);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> list = new HashSet<>();
        for (T o : elements) {
            list.add(o);
        }
        return list;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        HashMap<K, V> map = new HashMap<>();
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < keys.size(); i ++) {
            map.put((K) keys.get(i), (V) values.get(i));
        }
        return map;
    }
}
