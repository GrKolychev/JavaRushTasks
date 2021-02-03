package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()))) {
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            text = sb.toString();
            text = text.replaceAll("\\p{P}", "");
            bw.write(text);
        }
        reader.close();
    }
}
