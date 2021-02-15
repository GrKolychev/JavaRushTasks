package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name1", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            Date date = new Date();
            User user1 = new User();
            user1.setFirstName("ddwd");
            user1.setLastName("213");
            user1.setBirthDate(date);
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);
            javaRush.users.add(user1);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter pw = new PrintWriter(outputStream);
            for (User user: users) {
                pw.println(user.getFirstName());
                pw.println(user.getLastName());
                pw.println(user.getBirthDate().getTime());
                pw.println(user.getCountry().getDisplayName());
                pw.println(user.isMale());
            }
            pw.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String firstName = null;
            String lastName = null;
            Date birthDate = null;
            String country = null;
            String sex = null;
            while (reader.ready()){
                User user = new User();
                 firstName = reader.readLine();
                 lastName = reader.readLine();
                 birthDate = new Date(Long.parseLong(reader.readLine()));
                 country = reader.readLine();
                 sex = reader.readLine();
                 user.setFirstName(firstName);
                 user.setLastName(lastName);
                 user.setBirthDate(birthDate);
                 switch (country){
                     case "Ukraine": {
                         user.setCountry(User.Country.UKRAINE);
                         break;
                     }
                     case "Russia" : {
                         user.setCountry(User.Country.RUSSIA);
                         break;
                     }
                     case "Other" : {
                         user.setCountry(User.Country.OTHER);
                         break;
                     }
                 }

                 user.setMale(Boolean.parseBoolean(sex));
                 users.add(user);
            }
            reader.close();
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
