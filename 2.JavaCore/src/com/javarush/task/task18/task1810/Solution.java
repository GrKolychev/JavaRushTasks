package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        byte [] buffer = null;
        while (true) {
            fis = new FileInputStream(reader.readLine());
            buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            if (buffer.length<1000){
            DownloadException exception = new DownloadException();
            throw exception;
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
