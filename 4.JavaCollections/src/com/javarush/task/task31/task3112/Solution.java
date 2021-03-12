package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/Users/1/Desktop/Java"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);               //create url
        InputStream is = url.openStream();             //open stream
        Path tempFile = Files.createTempFile("temp-",".temp");  //create temp File
        Files.copy(is,tempFile,StandardCopyOption.REPLACE_EXISTING);            //copy file from stream to temp file
        String nameOfFile = Paths.get(url.getFile()).getFileName().toString();      //get filename from url
        Path result = downloadDirectory.resolve(nameOfFile);                        //concat user`s path and url`s file name
        Files.move(tempFile,result,StandardCopyOption.REPLACE_EXISTING);            //move file from temp directory to user`s directory
        return result;// implement this method                                      //return path
    }
}
