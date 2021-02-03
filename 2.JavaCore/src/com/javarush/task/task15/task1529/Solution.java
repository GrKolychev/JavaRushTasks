package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();

        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String console = null;
        int amountOfPassengers = 0;
        try {
            console = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (console.equals("helicopter")) {
            result = new Helicopter();
        }
        else if (console.equals("plane")){
            try {
                amountOfPassengers=Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = new Plane(amountOfPassengers);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add your code here - добавьте код тут
    }
}
