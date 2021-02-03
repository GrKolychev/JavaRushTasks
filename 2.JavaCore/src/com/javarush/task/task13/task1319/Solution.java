package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        String toWrite = null;


        do {
            toWrite = reader.readLine();
            bufferedWriter.write(toWrite);
            bufferedWriter.newLine();
        }while (!toWrite.equals("exit"));

        reader.close();
        bufferedWriter.close();


        // напишите тут ваш код
    }
}
