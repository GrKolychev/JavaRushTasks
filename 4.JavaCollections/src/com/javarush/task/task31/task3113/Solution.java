package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {         //extends SimpleFileVisitor
    int directoryCounter = 0;                       //counters
    int filesCounter = 0;
    int amountOfBytes = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {   //override preVisitDirectory method to count amount of directories.
        if (attrs.isDirectory()) {
            directoryCounter++;
            return FileVisitResult.CONTINUE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {         //override visitFile method to count amount of files and sizes of files.
        filesCounter++;
        byte[] b = Files.readAllBytes(file);
        amountOfBytes += b.length;
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));               //get path via console
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)) System.out.println(path.toString() + " - не папка");          //check path
        else {
            final Solution solution = new Solution();
            Files.walkFileTree(path, solution);                                                       //call walkFileThree method
            System.out.println("Всего папок - " + (solution.directoryCounter - 1));                     // print results
            System.out.println("Всего файлов - " + solution.filesCounter);
            System.out.println("Общий размер - " + solution.amountOfBytes);
        }

    }
}
