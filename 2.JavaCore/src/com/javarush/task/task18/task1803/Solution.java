package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long[] arrBytes = new long[256];

        while (fileInputStream.available()>0) arrBytes[fileInputStream.read()]++;
        fileInputStream.close();
        long maxRepeat = 0;
        for (int i = 0; i < arrBytes.length; i++) {
            if (arrBytes[i]>maxRepeat) maxRepeat = arrBytes[i];
        }

        for (int i = 0; i < arrBytes.length; i++) {
            if (arrBytes[i]==maxRepeat){
                System.out.print(i+ " ");
            }
        }
    }
}
