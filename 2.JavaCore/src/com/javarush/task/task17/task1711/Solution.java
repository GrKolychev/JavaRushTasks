package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //args= new String[]{"-c", "Иванов", "м", "04/01/1990", "Иванова", "ж", "18/05/1999"};
         // args= new String[]{"-u", "0","Петров", "м", "04/01/1991", "1","Петрова", "ж", "18/05/1995"};
         //args= new String[]{"-d", "0","1"};
        //args= new String[]{"-i", "0","1"};
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String name = null;
        Sex sex = null;
        Date birthDate = null;
        Person person = null;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        birthDate = format.parse(args[i + 2]);
                        if (args[i + 1].equals("м")) {
                            sex = Sex.MALE;
                            person = Person.createMale(name, birthDate);
                        } else if (args[i + 1].equals("ж")) {
                            sex = Sex.FEMALE;
                            person = Person.createFemale(name, birthDate);
                        }
                        allPeople.add(person);
                        System.out.print(allPeople.indexOf(person)+" ");
                    }
                }
                break;

            case "-u":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=4) {
                        name = args[i+1];
                        if (args[i+2].equals("м"))
                            sex = Sex.MALE;
                        else if (args[i+2].equals("ж"))
                            sex = Sex.FEMALE;
                        birthDate = format.parse(args[i+3]);
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(name);
                        person.setSex(sex);
                        person.setBirthDate(birthDate);
                    }
                }
                break;

            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }

                break;

            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        name = allPeople.get(Integer.parseInt(args[i])).getName();
                        sex = allPeople.get(Integer.parseInt(args[i])).getSex();
                        birthDate = allPeople.get(Integer.parseInt(args[i])).getBirthDate();
                        System.out.print(name + " ");
                        if (sex == Sex.MALE)
                            System.out.print("м ");
                        else
                            System.out.print("ж ");
                        System.out.print(format1.format(birthDate));
                        System.out.println("");
                    }
                }
                break;

        }
    }
}
