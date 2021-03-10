package com.javarush.task.task31.task3101;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       // args = new String[]{"C:/Users/1/Desktop/123", "C:/Users/1/Desktop/result.txt"};
        File fileResult = new File(args[1]);             //создаем начальный файл
        File fileContent = new File(fileResult.getParent() + "/allFilesContent.txt"); //создаем файл, в который должен быть переименован начальный файл
        if (FileUtils.isExist(fileResult)) FileUtils.renameFile(fileResult, fileContent); //если начальный файл существует, то переименовывыем изначальный файл
        try (FileOutputStream fos = new FileOutputStream(fileContent);) { // открываем выходной поток
            ArrayList<File> listOfFiles = new ArrayList<>();  //создаем arraylist для хранения файлов размером меньше 50 байт
        fillFileList(listOfFiles, args[0]);  // вызываем метод для заполнения листа файлов
        listOfFiles.sort(new Comparator<File>() {   //сортируем список файлов по имени
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

            for (File file: listOfFiles) {                          // пишем байты из всех файлов списка в общий файл
                FileInputStream fis = new FileInputStream(file);
                while (fis.available()>0){
                    fos.write(fis.read());
                }
                fos.write(System.lineSeparator().getBytes());
                fos.flush();
                fis.close();
            }

        }
    }

    public static void fillFileList (ArrayList<File> listOfFiles, String path) { //проходим по дирректории переданной в параметр с помощью рекурсии
        File [] list = new File(path).listFiles();                                 // и заполняем переданный в параметр лист файлами размером менее 50 байт
        for (File file:list) {
            if (file.isDirectory()) fillFileList(listOfFiles, file.getPath());
            else if (file.length()<=50){
                listOfFiles.add(file);
            }
        }
    }
}
