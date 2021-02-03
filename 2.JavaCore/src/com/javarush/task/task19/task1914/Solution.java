package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String [] data = byteArrayOutputStream.toString().split(" ");
        Integer result = null;
        if (data[1].equals("+")){
            result = Integer.parseInt(data[0])+Integer.parseInt(data[2]);
        }
        else if (data[1].equals("-")) {result = Integer.parseInt(data[0])-Integer.parseInt(data[2]);}
        else if (data[1].equals("*")) {result = Integer.parseInt(data[0])*Integer.parseInt(data[2]);}

        String toPrint = byteArrayOutputStream.toString().replaceAll("\n|\r\n", "")+result.toString();

        System.setOut(console);
        System.out.println(toPrint);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

