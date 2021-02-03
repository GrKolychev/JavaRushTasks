package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        double amountOfAllSymbols = 0;
        double amountOfSpaces = 0;
        DecimalFormat df = new DecimalFormat("##.00");
        while(fis.available()>0){
            amountOfAllSymbols++;
            if ((char)fis.read() == ' '){
                amountOfSpaces++;
            }
        }
        System.out.println(df.format(amountOfSpaces/amountOfAllSymbols*100));
        fis.close();
    }
}
