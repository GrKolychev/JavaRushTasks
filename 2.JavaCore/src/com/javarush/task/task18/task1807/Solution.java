package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int amountOfCommas = 0;
        while (fis.available()>0){
            if (fis.read()==44) amountOfCommas++;
        }
        fis.close();
        System.out.println(amountOfCommas);

    }
}
