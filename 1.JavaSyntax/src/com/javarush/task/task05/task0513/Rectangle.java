package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top;
    int left;
    int width;
    int height;
    public void initialize(int top){
        this.top = top;
    }
    public void initialize(int top, int left){
        this.left = left;
    }
    public void initialize(int top, int left, int width){
        this.width = width;
    }
    public void initialize(int top, int left, int width, int height){
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
