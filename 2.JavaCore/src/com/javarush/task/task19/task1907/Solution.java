package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(FileReader fr = new FileReader(reader.readLine())){
            StringBuilder text= new StringBuilder();
           while (fr.ready()){
               char x =(char)fr.read();
               text.append(Character.toString(x));
           }
           String result = text.toString();
           String [] splitted = result.split("\\p{P}|\\s");
           int counter = 0;
            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].equals("world")){
                    counter++;
                }
            }
            System.out.println(counter);
        }

        reader.close();
    }
}
