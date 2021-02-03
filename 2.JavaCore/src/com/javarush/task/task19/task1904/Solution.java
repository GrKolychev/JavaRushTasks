package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println(new PersonScannerAdapter(new Scanner(new File("C:/Users/1/Desktop/123.txt"),"windows-1251")).read());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner = null;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String [] splittedLine = line.split(" ",4);
            DateFormat df = new SimpleDateFormat ("dd MM yyyy");
            Date dt = null;
            try {
                dt = df.parse(splittedLine[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(splittedLine[1],splittedLine[2],splittedLine[0],dt);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
