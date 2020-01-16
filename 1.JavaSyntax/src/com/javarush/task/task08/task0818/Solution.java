package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("dima", 1000);
        map.put("dimaa", 2332);
        map.put("dimaaa", 423);
        map.put("dimaaaa", 100);
        map.put("dimaaaaaa", 10);
        map.put("dimaaaaaaaa", 12000);
        map.put("diaaaaaaaaaam", 10300);
        map.put("diaaaaaaaaaaam", 10040);
        map.put("daaaaaaaaaaaim", 10050);
        map.put("dimaaaaaaaaaaaaa", 10060);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        for(Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() < 500) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}