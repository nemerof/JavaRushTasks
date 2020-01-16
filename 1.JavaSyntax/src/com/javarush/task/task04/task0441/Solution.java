package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(rd.readLine());
        int number2 = Integer.parseInt(rd.readLine());
        int number3 = Integer.parseInt(rd.readLine());
        if (number1 == number2 && number2 == number3){
            System.out.println(number1);
        }
        else{
            System.out.println(number1 + number2 + number3 - max3(number1, number2, number3) - min3(number1, number2, number3));
        }
    }
    public static int max3(int a, int b, int c){
        if (a >= b && a >= c){
            return (a);
        }
        else if (b >= c && b >= a){
            return (b);
        }
        else{
            return (c);
        }
    }
    public static int min3(int a, int b, int c){
        if (a <= b && a <= c){
            return (a);
        }
        else if (b <= c && b <= a){
            return (b);
        }
        else{
            return (c);
        }
    }
}
