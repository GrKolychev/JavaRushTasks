package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String name = null;
        Sex sex = null;
        Date birthDate;
        Person person = null;

        switch (args[0]) {
            case "-c":
                name = args[1];
                birthDate = format.parse(args[3]);
                if (args[2].equals("м")) {
                    person = Person.createMale(name, birthDate);
                } else if (args[2].equals("ж")) {
                    person = Person.createFemale(name, birthDate);
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                break;

            case "-u":
                name = args[2];
                if (args[3].equals("м"))
                    sex = Sex.MALE;
                else if (args[3].equals("ж"))
                    sex = Sex.FEMALE;
                birthDate = format.parse(args[4]);
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(name);
                person.setSex(sex);
                person.setBirthDate(birthDate);
                break;


            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                break;

            case "-i":
                name = allPeople.get(Integer.parseInt(args[1])).getName();
                sex = allPeople.get(Integer.parseInt(args[1])).getSex();
                birthDate = allPeople.get(Integer.parseInt(args[1])).getBirthDate();
                System.out.print(name + " ");
                if (sex == Sex.MALE)
                    System.out.print("м ");
                else
                    System.out.print("ж ");
                System.out.print(format1.format(birthDate));

                break;

        }

    }
}
