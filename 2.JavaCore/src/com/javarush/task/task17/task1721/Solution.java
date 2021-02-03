package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            allLines = Files.readAllLines(Paths.get(reader.readLine()));
            forRemoveLines = Files.readAllLines(Paths.get(reader.readLine()));
            } catch (IOException e){
            e.printStackTrace();
        }
        try {
            Solution solution = new Solution();
            solution.joinData();
        }catch (CorruptedDataException e){
            System.out.println("никуя не совпадает");
        }


    }

    public void joinData() throws CorruptedDataException {
            if (allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);
            }
            else {
                allLines.clear();
                throw new CorruptedDataException();
            }

        System.out.println("Все совпадает");
    }
}
