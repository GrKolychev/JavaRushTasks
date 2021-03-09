package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] b) {

        byte [][] a = new byte[b.length+1][b.length+1]; //create a new array with a length and height one greater than the original array
        for (int i = 0; i <a.length ; i++) {            // feed array by 0
            for (int j = 0; j <a.length ; j++) {
                a[i][j]=0;
            }
        }
        for (int i = 0; i <b.length ; i++) {            //copy original array to new array
            for (int j = 0; j <b.length ; j++) {
               a[i][j] = b[i][j];
            }

        }

       int amountOfRectangles = 0;
        for (int i = 0; i < a.length; i++) {                //check elements of new array. if element = 1, and got neighbors right and down = 0
            for (int j = 0; j < a.length; j++) {            //counter of rectangles++
                if (a[j][i]!=0&&a[j+1][i]==0&&a[j][i+1]==0) {
                    amountOfRectangles++;
                }
                else continue;
            }
        }
        
        return amountOfRectangles;
    }
}
