package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        File file = new File("C:/Users/1/Desktop/123.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Solution savedObject = new Solution(4);
        oos.writeObject(savedObject);
        Solution loadedObject = new Solution(6);
        loadedObject = (Solution)ois.readObject();
        System.out.println(loadedObject.string.equals(savedObject.string));
        System.out.println(savedObject);
        System.out.println(loadedObject);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
