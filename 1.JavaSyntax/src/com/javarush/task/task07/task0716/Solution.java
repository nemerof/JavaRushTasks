package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {//public static ArrayList<String> fix(ArrayList<String> list)
        //напишите тут ваш код
        boolean isContain1;//удалять из списка строк все слова, содержащие букву «р»
        boolean isContain2;//удваивать все слова содержащие букву «л»
        for (int i = 0; i < list.size();) {
            isContain1 = list.get(i).contains("р");
            isContain2 = list.get(i).contains("л");
            if (isContain1 & !isContain2)
                list.remove(i);
            else if (isContain2 & !isContain1) {
                list.add(i, list.get(i));
                i += 2;
            }
            else i++;
        }
        return list;
    }
}