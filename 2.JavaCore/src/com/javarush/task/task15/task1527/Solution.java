package com.javarush.task.task15.task1527;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws MalformedURLException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> listOfObjParametersDouble = new ArrayList<>();
        ArrayList<String> listOfObjParametersString = new ArrayList<>();
        String url = scanner.nextLine();
        String parameters = url.substring(url.indexOf('?') + 1);
        String[] split1 = parameters.split("[&]");
        for (int i = 0; i < split1.length; i++) {
            if (split1[i].contains("=")) {
                String[] split2 = split1[i].split("=");
                System.out.print(split2[0] + " ");
                if (split2[0].equals("obj")) {
                    Double d = null;
                    try {
                        d = Double.parseDouble(split2[1]);
                        listOfObjParametersDouble.add(d);
                    } catch (NumberFormatException e) {
                        listOfObjParametersString.add(split2[1]);
                    }

                }
            } else {
                System.out.print(split1[i] + " ");
            }


        }
        System.out.println("");

        for (Double x : listOfObjParametersDouble) {
            alert(x);
        }
        for (String x : listOfObjParametersString) {
            alert(x);
        }
        scanner.close();

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
