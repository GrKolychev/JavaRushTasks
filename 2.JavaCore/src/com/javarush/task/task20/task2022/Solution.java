package com.javarush.task.task20.task2022;

import java.awt.*;
import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/1/Desktop/321.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/1/Desktop/321.txt"));
        Solution solution = new Solution("C:/Users/1/Desktop/123.txt");
        solution.writeObject("4843156");
        oos.writeObject(solution);

        Solution solution1 = (Solution) ois.readObject();
        solution1.writeObject("788888");
    }
}
