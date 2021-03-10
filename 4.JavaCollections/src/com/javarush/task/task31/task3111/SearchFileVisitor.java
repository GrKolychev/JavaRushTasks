package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = Integer.MIN_VALUE;                    //объявляем поля для поиска совпадений критериев
    private int maxSize = Integer.MAX_VALUE;                    //начальные значения полей подобраны так, чтобы в случае, если они не заданы пользователем,
    private List<Path> foundFiles = new ArrayList<>();          //поиск осуществлялся только по заданным полям.

    public List<Path> getFoundFiles() {                            //гетер для листа с файлами, где найдены совпадения
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {                  //сеттеры для критериев поиска
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String cont = new String(content,"UTF-8");
        boolean containsName = true;
        boolean containsContent = true;                     //объявляем переменные флаги для индикации наличия совпадений
        boolean minSizeAreCorrect = true;
        boolean maxSizeAreCorrect = true;

        if (partOfName!=null&&!file.getFileName().toString().contains(partOfName)) containsName = false;        //если условия не выполняются, то значения флагов устанавливаются в false
        if (partOfContent!=null&&!cont.contains(partOfContent)) containsContent = false;
        if (!(content.length>minSize)) minSizeAreCorrect =false;
        if (!(content.length<maxSize)) maxSizeAreCorrect = false;

        if(containsContent&&containsName&&maxSizeAreCorrect&&minSizeAreCorrect) foundFiles.add(file);


        return FileVisitResult.CONTINUE;
    }
}
