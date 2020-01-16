package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top, left, width, height;
    public Rectangle(int top){
        this.top = top;
    }
    public Rectangle(int top, int left){
        this.left = left;
    }
    public Rectangle(int top, int left, int width){
        this.width = width;
    }
    public Rectangle(int top, int left, int width, int height){
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
