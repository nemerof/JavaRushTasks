package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    static PhotoPaint photoPaint = new PhotoPaint();
    static Color[][] image =  {{Color.YELLOW, Color.YELLOW, Color.YELLOW},
                        {Color.YELLOW, Color.BLUE, Color.YELLOW},
                        {Color.YELLOW, Color.YELLOW, Color.YELLOW}};

    public static void main(String[] args) {
        System.out.println("Before");

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        photoPaint.paintFill(image, 0, 0, Color.RED);
        System.out.println("After");

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }

    }
}
