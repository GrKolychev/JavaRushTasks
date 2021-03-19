package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        try{
        if (fileName.endsWith(".xml")) {            // случай, когда пропертис хранятся в xml файле
            Properties properties = new Properties();
            properties.loadFromXML(new FileInputStream(fileName));
            return properties;
        }
        else {                                      // случай, когда в любом другом типе файлов
            Properties properties = new Properties();
            properties.load(new FileReader(fileName));
            return properties;
        }

        } catch (IOException e) {
            return new NullObject();
        }

    }

    public static class NullObject extends Properties{          //создаем NullObject, для использования при возникновении ошибок при чтении пропертис.

        @Override
        public void list(PrintStream out) {
        }

        @Override
        public void list(PrintWriter out) {
        }
    }
}


