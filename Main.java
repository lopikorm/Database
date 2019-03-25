package com.company;

import com.company.entity.*;
import com.company.input.ReadFile;
import com.company.output.WriteFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String user = "postgres";
        String pass = "sewer736";

        try {
            Class.forName("org.postgresql.Driver");
           Connection connection = DriverManager.getConnection(url, user, pass);



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No driver for PostgreSQL found");
            cnfe.printStackTrace();
        }




        Showplace obelisk = new Showplace("Obelisk", new City("Ulyanovsk"), new Street("Minaeva"), 1, Boolean.TRUE, Category.MONUMENT, Rating.five);

        Showplace hiruki = new Showplace("Hiruki", new City("Ulyanovsk"), new Street("Goncharova"), 12, Boolean.FALSE, Category.RESTAURANT, Rating.four);
        Showplace kremlin = new Showplace("Kremlin", new City("Moskow"), new Street("Red Square"), 1, Boolean.TRUE, Category.MUSEUM, Rating.ten);

        //System.out.println(obelisk.getName() + " and his code - " + obelisk.hashCode());


        //чтение из файла классов
        String fileContent = ReadFile.readFile("E:\\Учеба\\database\\src\\com\\company\\input.txt");
        WriteFile.writeFile(fileContent + " written by Valera", "E:\\Учеба\\database\\src\\com\\company\\output.txt");

        //вывод на печать прочитанного из файла
        System.out.println(fileContent);


        /** String[] strings = fileContent.split(";");
         for(String currentString : strings) {
         // Showplace() = currentString;
         System.out.println(currentString);
         }*/

        //создаем массив
        //String line;
        List<Showplace> showplaceList = new ArrayList<Showplace>();


        //добавляем элементы в массив
        showplaceList.add(obelisk);
        showplaceList.add(hiruki);
        showplaceList.add(kremlin);


       /* while ((fileContent) != null) {
            Showplace newShowplace = new Showplace();
            new Showplace() = fileContent;
            showplaceList.add(new Showplace());*/




        /*Collections.sort(showplaceList,(String first, String second) -> {
            return Integer.compare(first.length(), second.length());
        });*/
            //перебираем элементы итератором и выводим на печать

            Iterator iterator = showplaceList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        }








    }




