package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);               //создаем файл с путем к директории
        List<String> result = new ArrayList<>();    //создаем лист, в котором будут храниться пути файлов, найденные в директории
        Queue<File> fileTree = new PriorityQueue<>();   //создаем очередь, в которой будут храниться все файлы из директории, в том числе и директории
        Collections.addAll(fileTree, rootDir.listFiles());  // добавляем в очерердь все файлы из директории
        while (!fileTree.isEmpty())
        {
            File currentFile = fileTree.remove();           //Получаем и удаляем главу очереди, создаем файл с помощью полученного из очереди пути.
            if(currentFile.isDirectory()){                              //проверяем, является ли глава очереди дирректорией.
                Collections.addAll(fileTree, currentFile.listFiles());  //если являеися, то добавляем все содержимое директории в очерердь.
            } else {
                result.add(currentFile.getAbsolutePath());             //если является файлом, то получаем его абсолютный путь и добавляем в лист с результатом
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
    }
}
