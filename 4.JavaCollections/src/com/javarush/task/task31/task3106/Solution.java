package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            set.add(args[i]);
        }

        ArrayList <FileInputStream> listOfStreams = new ArrayList<>();

        for (String s: set) {
            listOfStreams.add(new FileInputStream(s));
        }

       try( SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(listOfStreams));
        ZipInputStream zis = new ZipInputStream(sis);
        FileOutputStream fos = new FileOutputStream(args[0])){
           for (ZipEntry entry = null;(entry = zis.getNextEntry())!=null;) {
               final int bufferSize = 1024;
               byte[] buffer = new byte[bufferSize];
               for(int readBytes = -1; (readBytes = zis.read(buffer, 0, bufferSize)) > -1; ) {
                   fos.write(buffer, 0, readBytes);
               }
               fos.flush();
           }
       }
    }
}
