package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String fileName = reader.readLine();
            try(FileInputStream fis = new FileInputStream(fileName);){

            }catch (FileNotFoundException ex){
                System.out.println(fileName);
                break;
            }
        }
    }
}
