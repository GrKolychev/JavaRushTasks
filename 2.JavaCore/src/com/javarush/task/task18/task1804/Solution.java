package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        long[] bytes = new long[256];

        while (fis.available() > 0) bytes[fis.read()]++;
        fis.close();

        long minByte = Long.MAX_VALUE;

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < minByte&&bytes[i]!=0) minByte = bytes[i];
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == minByte) System.out.print(i + " ");
        }
    }
}
