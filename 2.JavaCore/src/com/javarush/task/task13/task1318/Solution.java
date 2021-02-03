package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        while (inStream.available() > 0) {
            System.out.print((char) inStream.read());
        }
        reader.close();
        inStream.close();
    }
}