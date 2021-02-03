package com.javarush.task.task18.task1821;

import java.io.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[] {"C:/Users/1/Desktop/123.txt"};
        FileInputStream fis = new FileInputStream(args[0]);
        byte [] data = new byte[fis.available()];
        fis.read(data);
        for (int i = 0; i < 256; i++) {
            int counter = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[j]==i){
                    counter++;
                }
            }
           if (counter>0)System.out.println((char)i +" "+counter);
        }
    }
}
