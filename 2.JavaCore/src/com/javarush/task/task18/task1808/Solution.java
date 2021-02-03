package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;
        String fileName3 = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        byte [] buffer = null;
        try (FileInputStream fis = new FileInputStream(fileName1)){
            buffer = new byte[fis.available()];
            fis.read(buffer);
        }catch (IOException e){
            e.printStackTrace();
        }

        if (buffer.length%2==0){
            try (FileOutputStream fos1 = new FileOutputStream(fileName2);){
                fos1.write(buffer,0,buffer.length/2);
            }catch (IOException e){
                e.printStackTrace();
            }
            try (FileOutputStream fos2 = new FileOutputStream(fileName3);){
                fos2.write(buffer,buffer.length/2,buffer.length/2);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            try (FileOutputStream fos1 = new FileOutputStream(fileName2);){
                fos1.write(buffer,0,buffer.length/2+1);
            }catch (IOException e){
                e.printStackTrace();
            }
            try (FileOutputStream fos2 = new FileOutputStream(fileName3);){
                fos2.write(buffer,buffer.length/2+1,buffer.length/2);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
