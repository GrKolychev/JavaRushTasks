package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName));){
            while (fileReader.ready()){
                String string = fileReader.readLine();
                int counter = 0;
                String [] splitedString = string.split(" ");
                for (int i = 0; i < splitedString.length; i++) {
                    if (words.contains(splitedString[i]))
                        counter++;
                }
                if (counter==2)
                    System.out.println(string);
            }
        }
    }
}
