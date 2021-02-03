package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileReader fr = new FileReader(reader.readLine());
            FileWriter fw = new FileWriter(reader.readLine());
            BufferedReader fileReader = new BufferedReader(fr);
            BufferedWriter fileWriter = new BufferedWriter(fw)){
            StringBuilder text = new StringBuilder();
            String inputLine;
            while ((inputLine = fileReader.readLine())!=null){
                text.append(inputLine);
                text.append("\n");
            }
            String string = text.toString();
            string = string.replace(".","!");
            fileWriter.write(string);
        }catch (IOException e){
            e.printStackTrace();
        }
        reader.close();
    }
}
