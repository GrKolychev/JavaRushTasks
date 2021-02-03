package com.javarush.task.task19.task1908;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()))) {
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine()).append(" ");
            }
            String text = sb.toString();
            String[] vsyaHuinya = text.split(" ");
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < vsyaHuinya.length; i++) {
                try {

                    Integer number = Integer.parseInt(vsyaHuinya[i]);
                    sb2.append(number.toString()+" ");
                }catch (NumberFormatException e){

                }
            }
            String toOut = sb2.toString().trim();
            bw.write(toOut);
            System.out.println(toOut);


        }
        reader.close();

    }
}
