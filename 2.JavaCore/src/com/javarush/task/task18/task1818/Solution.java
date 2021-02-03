package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileInputStream fis2 = new FileInputStream(reader.readLine());
        while (fis.available()>0){
            fos.write(fis.read());
        }
        while (fis2.available()>0){
            fos.write(fis2.read());
        }
        fos.close();
        fis.close();
        fis2.close();

    }
}
