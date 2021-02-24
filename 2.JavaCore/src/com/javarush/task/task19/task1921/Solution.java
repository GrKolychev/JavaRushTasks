package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        //args = new String[]{"C:/Users/1/Desktop/123.txt"};

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));) {
            String s;

            while (fileReader.ready()) {
                String name = "";
                String dateString = "";
                s = fileReader.readLine();
                String[] strings = s.split(" ");
                for (int i = 0; i <= strings.length - 4; i++) {
                    name += strings[i];
                    if (i<strings.length-4)
                        name+=" ";

                }
                for (int i = strings.length - 3; i < strings.length; i++) {
                    dateString +=strings[i]+" ";
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy ");
                Date date = sdf.parse(dateString);

                PEOPLE.add(new Person(name,date));
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
