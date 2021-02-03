package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s = reader.readLine();
            if (s.equals("exit")){break;}
            new ReadThread(s);
        }


    }

    public static class ReadThread extends Thread {
        private FileInputStream fis;
        private String fieName;

        public ReadThread(String fileName) throws FileNotFoundException {
            fis = new FileInputStream(fileName);
            this.fieName = fileName;
            start();
        }

        @Override
        public void run() {
            super.run();
            try {
                resultMap.put(fieName, maxByte());
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public int maxByte() throws IOException {
            int[] bytes = new int[256];
            while (fis.available() > 0) {
                int i = fis.read();
                bytes[i]++;
            }

            int maximum = 0;
            int indexOfMax = 0;
            for (int i = 0; i < bytes.length; i++) {

                if (bytes[i] > maximum) {
                    maximum = bytes[i];
                    indexOfMax = i;
                }
            }
            return indexOfMax;
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
