package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        List<String> linesOfFile1 = new ArrayList<>();// Here we are creating lists of lines from files.
        List<String> linesOfFile2 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

             BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()))) {

            while (fileReader1.ready()) {             // reading lines from file.
                linesOfFile1.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                linesOfFile2.add(fileReader2.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count1 = 0;
        int count2 = 0;
        while (count1 < linesOfFile1.size() && count2 < linesOfFile2.size()) {
            if (linesOfFile1.get(count1).equals(linesOfFile2.get(count2))) {
                lines.add(new LineItem(Type.SAME, linesOfFile1.get(count1)));
                count1++;
                count2++;
            } else if (count1 + 1 < linesOfFile1.size() && linesOfFile1.get(count1 + 1).equals(linesOfFile2.get(count2))) {
                lines.add(new LineItem(Type.REMOVED, linesOfFile1.get(count1++)));
            } else if (count2 + 1 < linesOfFile2.size() && linesOfFile1.get(count1).equals(linesOfFile2.get(count2 + 1))) {
                lines.add(new LineItem(Type.ADDED, linesOfFile2.get(count2++)));
            }
            if (count1 == linesOfFile1.size() && count2 < linesOfFile2.size()) {
                lines.add(new LineItem(Type.ADDED, linesOfFile2.get(count2)));
            } else if (count2 == linesOfFile2.size() && count1 < linesOfFile1.size()) {
                lines.add(new LineItem(Type.REMOVED, linesOfFile1.get(count1)));
            }

        }


        for (LineItem x : lines) {
            System.out.println(x.type + x.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
