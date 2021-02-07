package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String advertising = "JavaRush - курсы Java онлайн";
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] printSmthn = byteArrayOutputStream.toString().split("\n");
        System.setOut(consoleStream);
        int counter = 0;
        for (String s : printSmthn) {
            System.out.println(s);
            counter++;
            if (counter % 2 == 0)
                System.out.println(advertising);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}


