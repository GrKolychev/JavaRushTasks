package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:/Users/1/Downloads/Технический отчет ЖГТЭС.docx","C:/Users/1/Downloads/Megaplan-2020-08-31-15-03-10.zip"};
        List <Content> filesFromZip = new ArrayList<>(); // создаем лист экземпляров класса Content для хранения всей информации из архива
        try(FileInputStream fis = new FileInputStream(args[1]);
        ZipInputStream zis = new ZipInputStream(fis);){         // открываем входной поток для чтения из архива
            ZipEntry entry;
            byte [] buffer = new byte[1024];
            while ((entry=zis.getNextEntry())!=null){               //цикл работает, пока есть доступные ZipEntry в ZipInputStream
                ByteArrayOutputStream baos = new ByteArrayOutputStream();       //создаем ByteArrayOutputStream для записи байтов из файлов в массив buffer
                int length = 0;
                while ((length = zis.read(buffer))>0){                      //читаем байты из файла, пока в нем есть доступные байты
                    baos.write(buffer,0,length);                        //пишем байты в массив buffer
                }
                filesFromZip.add(new Content(entry.getName(),baos.toByteArray()));      //создаем экземпляр класса Content на основе имени ZipEntry и массива байтов, полученного из потока ByteArrayOutputStream
            }
        }

        try(FileOutputStream fos = new FileOutputStream(args[1]);
            ZipOutputStream zos = new ZipOutputStream(fos);){       //открываем поток для записи в арихв
            File file = new File(args[0]);                             // создаем экземпляр File, на осонове первого аргумента
            zos.putNextEntry(new ZipEntry("new/"+file.getName()));      //кладем в выходной поток новый ZipEntry в директорию new
            Files.copy (file.toPath(),zos);                                 //копируем файл в выходной поток
            for (Content content: filesFromZip) {
                if (!content.getFileName().equals("new/"+file.getName())) content.saveToFile(zos);      //пишем все остальные файлы, если их имя не идентично имени файла из первого аргумента
            }
        }

    }

    static class Content {                      //создаем класс, в экземплрах которого будет храниться контент из файлов архива
        String fileName;
        byte [] body;

        public Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        public String getFileName() {
            return fileName;
        }

        public void saveToFile (ZipOutputStream zos) throws IOException {           //метод, который пишет хранимый в экземпляре контент в ZipOutputStream, передаваемый в качестве аргумента
            zos.putNextEntry(new ZipEntry(fileName));
            zos.write(body);
            zos.closeEntry();
        }
    }
}
