package com.javarush.task.task19.task1919;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:/Users/1/Desktop/123.txt"};
        FileReader fr = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fr);
        HashMap <String,Double> map = new HashMap<>();

        while (reader.ready()){
            String [] data = reader.readLine().split(" ");
            if (!map.containsKey(data[0])){
                map.put(data[0],Double.parseDouble(data[1]));
            }else {
                Double d  = map.get(data[0]);
                d +=Double.parseDouble(data[1]);
                map.put(data[0],d);
            }

        }
        reader.close();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByKey()).forEach(entry -> System.out.println(entry.getKey() + " "+entry.getValue()));;


    }

}
