package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner= new Scanner(System.in);
        try (FileInputStream fileInputStream=new FileInputStream(scanner.nextLine());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            List<Integer> list= new ArrayList<>();
                while (fileReader.ready()){
                    int n = Integer.parseInt(fileReader.readLine());
                    if (n%2==0)
                        list.add(n);
                }
            Collections.sort(list);
                for (Integer x:list){
                    System.out.println(x);
                }

            } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
