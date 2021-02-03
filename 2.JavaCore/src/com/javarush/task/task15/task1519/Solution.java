package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = reader.readLine();
            double d;
            short sh;
            int integer;

            if (string.equals("exit"))
                break;

            try {
                integer = Integer.parseInt(string);
                if (integer > 0 && integer < 128) {
                    sh = (short) integer;
                    print(sh);
                } else {
                    print(integer);
                }
            } catch (NumberFormatException ex) {
                if (string.contains(".")) {
                    try {
                        d = Double.parseDouble(string);
                        print(d);
                    } catch (NumberFormatException exception) {
                        print(string);
                    }
                } else print(string);

            }
        }
    }




    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
