package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList <Integer> arrayOfBytes = new ArrayList<Integer>();
        while (fileInputStream.available()>0){
            Integer nextByte = fileInputStream.read();
            if (!arrayOfBytes.contains(nextByte))
                arrayOfBytes.add(nextByte);
        }
        Collections.sort(arrayOfBytes);
        for (Integer x: arrayOfBytes) {
            System.out.print(x+" ");
        }
        reader.close();
        fileInputStream.close();
    }
}
