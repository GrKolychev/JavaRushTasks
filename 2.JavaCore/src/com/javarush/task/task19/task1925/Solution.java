package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        //args = new String[]{"C:/Users/1/Desktop/123.txt", "C:/Users/1/Desktop/321.txt"};

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));) {
            String line = "";
            while (fileReader.ready()) {
                String string = fileReader.readLine();
                String[] words = string.split(" ");
                for (String word : words) {
                    if (word.length() > 6)
                        line += word + ",";
                }
            }
            fileWriter.write(line.substring(0, line.length() - 1));
           // System.out.println((line.substring(0, line.length() - 1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
