package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13,8,15,5,17};
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int i_middle = array.length/2;
        final double mediana = (array.length % 2 == 1) ? array[i_middle] : (array[i_middle - 1] + array[i_middle]) / 2;
        System.out.println("медиана - " + (int)mediana);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = (int)Math.round(Math.abs(mediana - o1) - Math.abs(mediana - o2));
                return (result == 0) ? (o1 - o2) : result;
            }
        });

        /* Arrays.sort(array, (o1, o2) -> {
            int result = (int)Math.round(Math.abs(mediana - o1) - Math.abs(mediana - o2));
            return (result == 0) ? (o1 - o2) : result;
        }); */

        return array;
    }
}
