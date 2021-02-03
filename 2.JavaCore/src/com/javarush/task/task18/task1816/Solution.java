package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {

        args = "C:/Users/1/Desktop/123.txt".split(" ");
            try {
            FileInputStream fis = new FileInputStream(args[0]);
            int amountOfUKLetters = 0;
            while (fis.available()>0){
                char ch = (char)fis.read();
                if (ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                    amountOfUKLetters++;
                }
            }
            System.out.println(amountOfUKLetters);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException d){
            d.printStackTrace();
        }


    }
}
