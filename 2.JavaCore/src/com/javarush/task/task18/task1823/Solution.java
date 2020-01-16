package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String row = rd.readLine();
            if (row.equals("exit")) {
                break;
            } else {
                ReadThread rt = new ReadThread(row);
                rt.start();
            }
        }

        rd.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        @Override
        public void run() {
                try {
                    synchronized (resultMap) {
                        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                        FileInputStream inputStream = new FileInputStream(fileName);
                        while (inputStream.available() > 0) {
                            int data = inputStream.read();
                            if (!map.containsKey(data)) {
                                map.put(data, 1);
                            } else {
                                int value = map.get(data);
                                map.replace(data, ++value);
                            }
                        }
                        int maxValue = map.firstEntry().getValue();
                        int maxKey = map.firstKey();

                        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                            if (maxValue < pair.getValue()) {
                                maxValue = pair.getValue();
                                maxKey = pair.getKey();
                            }
                        }

                        resultMap.put(fileName, maxKey);
                        inputStream.close();
                    }
                }
                catch (Exception e) {
                }
        }

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
    }
}
