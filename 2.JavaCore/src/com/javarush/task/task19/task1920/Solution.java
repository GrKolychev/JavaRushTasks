package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:/Users/1/Desktop/123.txt"};
        FileReader fr = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fr);
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String[] data = reader.readLine().split(" ");
            if (!map.containsKey(data[0])) {
                map.put(data[0], Double.parseDouble(data[1]));
            } else {
                Double d = map.get(data[0]);
                d += Double.parseDouble(data[1]);
                map.put(data[0], d);
            }
        }
        reader.close();
        Set set = map.entrySet();

        // Получаем итератор
        Iterator i = set.iterator();

        // Отображаем элементы
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            if (me.getValue().equals(Collections.max(map.values())))
            System.out.println(me.getKey());
        }

    }
}
