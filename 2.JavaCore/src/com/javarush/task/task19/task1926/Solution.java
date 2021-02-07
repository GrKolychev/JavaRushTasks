package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while (fileReader.ready()) {
            String string = fileReader.readLine();
            char[] letters = string.toCharArray();
            for (int i = letters.length - 1; i >= 0; i--) {
                System.out.print(letters[i]);

            }
            System.out.println("");
        }
        fileReader.close();

    }
}
