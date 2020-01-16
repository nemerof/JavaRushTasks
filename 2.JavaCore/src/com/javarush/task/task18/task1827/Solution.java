package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if (!(args.length == 0)) {
            if (args[0].equals("-c")) {
                //FileInputStream inputStream = new FileInputStream(fileName);
                reader = new BufferedReader(new FileReader(fileName));
                int id = 0;
                int maxID = 0;

                while (reader.ready()){
                    id = Integer.parseInt(reader.readLine().substring(0, 8).trim());
                    if (id > maxID)
                        maxID = id;
                }
                reader.close();
                //System.out.println(maxID);

                String goods = ++maxID + "";
                for (int i = goods.length(); i < 8; i++) {
                    goods = goods + " ";
                }

                goods = goods + args[1];
                for (int i = goods.length(); i < 38; i++) {
                    goods = goods + " ";
                }

                goods = goods + args[2];
                for (int i = goods.length(); i < 46; i++) {
                    goods = goods + " ";
                }

                goods = goods + args[3];
                for (int i = goods.length(); i < 50; i++) {
                    goods = goods + " ";
                }

                Writer fstream = new OutputStreamWriter(new FileOutputStream(fileName, true), "windows-1251");
                fstream.write("\r\n" + goods);
                fstream.close();
            }
        }
    }
}