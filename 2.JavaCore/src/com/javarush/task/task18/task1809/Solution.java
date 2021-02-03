package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);
        byte [] fileData = new byte[fis.available()];

        while (fis.available()>0){
            fis.read(fileData);
        }
            fis.close();
        for (int i = fileData.length - 1; i >-1 ; i--) {
            fos.write(fileData[i]);
        }
            fos.close();





    }
}
