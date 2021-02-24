package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] strings = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать"};
        for (int i = 0; i < 13; i++) {
            map.put(numbers[i], strings[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            String s = null;
            Integer x;
            while (fileReader.ready()) {
                s = fileReader.readLine();
                String[] elementsOfString = s.split(" ");
                for (int i = 0; i < elementsOfString.length; i++) {
                    try {
                        x = Integer.parseInt(elementsOfString[i]);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        if (x.equals(entry.getKey())) {
                            elementsOfString[i] = entry.getValue();
                            break;
                        }
                    }

                }
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < elementsOfString.length; j++) {
                    result.append(elementsOfString[j] + " ");
                }
                System.out.println(result.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

