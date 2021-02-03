package com.javarush.task.task16.task1632;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {



    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }



    public static class Thread1 extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            do {
                System.out.println("Ура");
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            } while (true);

        }
    }

    public static class Thread4 extends Thread implements Message {
            private boolean isAlive = true;
        public void run() {
            while (isAlive){

            }
        }

        @Override
        public void showWarning() {
            isAlive = false;
        }


    }

    public static class Thread5 extends Thread {
        Scanner scanner = new Scanner(System.in);
        private int sum;

        public void run() {
            while (true){
                String forsum = scanner.nextLine();
                if (forsum.equals("N"))break;
                sum+=Integer.parseInt(forsum);
            }
            System.out.println(sum);
        }
    }
}