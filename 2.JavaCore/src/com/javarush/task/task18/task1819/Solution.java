package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte [] file1data = null;
        try (FileInputStream fis1 = new FileInputStream(fileName1);){
            file1data = new byte[fis1.available()];
            fis1.read(file1data);
        }catch (IOException e){
            e.printStackTrace();
        }
        try (FileInputStream fis2 = new FileInputStream(fileName2);FileOutputStream fos = new FileOutputStream(fileName1);){
            while (fis2.available()>0){
                fos.write(fis2.read());
            }
            fos.write(file1data);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
