package com.javarush.task.task19.task1917;

import java.awt.*;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char c : cbuf) {
            System.out.print(c);
        }
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < off+len; i++) {
            System.out.print(cbuf[i]);
        }

    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        char[] ch = str.toCharArray();
        for (int i = off; i < off+len; i++) {
            System.out.print(ch[i]);
        }
    }

    public void close() throws IOException {
        fileWriter.close();
    }



    public static void main(String[] args)  {
       /* String str = "lolkek";
        int c = 1000;
        char [] chbuf = new char[] {'a','2',',','q'};
        File file = new File("C:/Users/1/Desktop/3.txt");
        FileWriter fileWriter = new FileWriter("C:/Users/1/Desktop/1.txt");

        FileConsoleWriter fileConsoleWriter1 = new FileConsoleWriter(fileWriter);
        FileConsoleWriter fileConsoleWriter2 = new FileConsoleWriter("C:/Users/1/Desktop/2.txt");
        FileConsoleWriter fileConsoleWriter3 = new FileConsoleWriter("C:/Users/1/Desktop/2.txt", true);
        FileConsoleWriter fileConsoleWriter4 = new FileConsoleWriter(file);
        FileConsoleWriter fileConsoleWriter5 = new FileConsoleWriter(file,true);

        fileConsoleWriter1.write(chbuf);
        System.out.println();
        fileConsoleWriter2.write(str);
        System.out.println();
        fileConsoleWriter3.write(c);
        System.out.println();
        fileConsoleWriter4.write(chbuf,1,2);
        System.out.println();
        fileConsoleWriter5.write(str,2,3);
        fileConsoleWriter1.close();
        fileConsoleWriter2.close();
        fileConsoleWriter3.close();
        fileConsoleWriter4.close();
        fileConsoleWriter5.close();*/

    }

}
