package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <String> namesOfFiles = new ArrayList<String>();

        while (true){
            String nameOfFile = reader.readLine();
            int indexOfPart = nameOfFile.lastIndexOf("part");
            int indexOfFile = Integer.parseInt(nameOfFile.substring(indexOfPart+1,nameOfFile.length()-1));
            namesOfFiles.add(indexOfFile,nameOfFile);
            if (!nameOfFile.equals("end"))
                break;
        }



    }
}
