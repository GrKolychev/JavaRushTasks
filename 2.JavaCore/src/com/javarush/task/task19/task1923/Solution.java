package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:/Users/1/Desktop/123.txt", "C:/Users/1/Desktop/321.txt"};
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
            while (fileReader.ready()) {
                String string = fileReader.readLine();
                String[] words = string.split(" ");
                for (String word : words) {
                    if (word.matches(".*[0-9]+.*"))
                        fileWriter.write(word + " ");

                }
            }
        }
    }
}
