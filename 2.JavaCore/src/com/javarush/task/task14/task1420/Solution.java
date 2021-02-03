package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();

        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(first);
            b = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (a<=0||b<=0) throw new Exception();

        ArrayList<Integer> listOfSimpleForA = new ArrayList<Integer>();//создание листов простых чисел, меньших, чем заданое число
        ArrayList<Integer> listOfSimpleForB = new ArrayList<Integer>();

        if (a > 10) {                               // заполнение листов простых чисел
            listBeforeTen(listOfSimpleForA, a);
            for (int i = 11; i <= a; i += 2) {
                if (isSimple(i))
                    listOfSimpleForA.add(i);
            }
        } else listBeforeTen(listOfSimpleForA, a);

        if (b > 10) {
            listBeforeTen(listOfSimpleForB, b);
            for (int i = 11; i < b; i += 2) {
                if (isSimple(i))
                    listOfSimpleForB.add(i);
            }
        } else listBeforeTen(listOfSimpleForB, b);

        ArrayList<Integer> listOfDividerForA = new ArrayList<>();       //создаем листы простых делителей
        ArrayList<Integer> listOfDividersForB = new ArrayList<>();
        getDividers(listOfSimpleForA, listOfDividerForA, a);        //вызываем метод поиска делителей
        getDividers(listOfSimpleForB, listOfDividersForB, b);
        ArrayList<Integer> listOfCommonDividers = new ArrayList<>();    //создаем лист общих делителей
        getCommonDividers(listOfDividerForA, listOfDividersForB, listOfCommonDividers);     //вызываем метод поиска общих делителей

        int nod = 0;
        if (listOfCommonDividers.isEmpty()){
            nod = 1;
        } else {
            nod = listOfCommonDividers.get(0);
            for (int i = 1; i <= listOfCommonDividers.size() - 1; i++) {                //перемножаем общие делители и находим НОД
                nod *= listOfCommonDividers.get(i);
            }
        }
        System.out.println(nod);
    }

    static ArrayList listBeforeTen(ArrayList<Integer> a, int x) {  //метод заполнения листа всех простых чисел до 10
        if (x >= 7) {
            a.add(2);
            a.add(3);
            a.add(5);
            a.add(7);
        } else if (x >= 5) {
            a.add(2);
            a.add(3);
            a.add(5);
        } else if (x >= 3) {
            a.add(2);
            a.add(3);
        } else if (x == 2) {
            a.add(2);
        }
        return a;
    }

    static boolean isSimple(int a) {//проверка является ли число простым
        int p = 0;
        if ((a % 2 == 0) || (a % 10 == 5))
            return false;
        else {
            for (int j = 3; j <= Math.sqrt(a); j += 2) {
                if (a % j == 0) {
                    p += 1;
                    break;
                }
            }
        }
        return p <= 0;
    }

    static ArrayList<Integer> getDividers(ArrayList<Integer> simpleList, ArrayList<Integer> dividersList, int number) { //метод получения всех простых делителей числа
        for (int i = 0; i < simpleList.size(); i++) {
            if (number % simpleList.get(i) == 0) {
                dividersList.add(simpleList.get(i));
                number /= simpleList.get(i);
                i = 0;
            }
        }
        return dividersList;
    }

    static ArrayList<Integer> getCommonDividers(ArrayList<Integer> listA, ArrayList<Integer> listB, ArrayList<Integer> commonList) { // метод получения всех общих простых делителей чисел
        for (Integer x1 : listA) {
            for (Integer x2 : listB) {
                if (x1.equals(x2)) {
                    commonList.add(x1);
                    listB.remove(x2);
                    break;
                }
            }
        }
        return commonList;
    }

    static int nod (int a,int b)
    {
        while(a!=0 && b!=0)
        {
            if(a>=b) a=a%b;
            else b=b%a;
        }
        return a+b;
    }
}


