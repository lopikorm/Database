package com.company;

import com.company.entity.*;
import com.company.input.ReadFile;
import com.company.output.WriteFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        //Работа с БД
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "sewer736";

        Connection c;
        Statement stmt;

        try {

           Class.forName("org.postgresql.Driver");
           c = DriverManager.getConnection(url, user, pass);
           c.setAutoCommit(false);
           String sql;
           stmt = c.createStatement();

          
           sql = "CREATE TABLE SHOWPLACE " +
                   "(ID INT PRIMARY KEY    NOT NULL, " +
                   "NAME            TEXT   NOT NULL, " +
                   "CITY            TEXT   NOT NULL, " +
                   "STREET          TEXT   NOT NULL, " +
                   "BUILDING        INT    NOT NULL, " +
                   "FREE            BOOLEAN,         " +
                   "CATEGORY        TEXT   NOT NULL, " +
                   "RATING          SMALLINT NOT NULL) ";

           stmt.executeUpdate(sql);
           stmt.close();
           c.commit();
           System.out.println("---Table created successfully");

           //добавляем данные
            stmt = c.createStatement();
            sql = "INSERT INTO SHOWPLACE (ID,NAME,CITY,STREET,BUILDING,FREE,CATEGORY,RATING) VALUES (1,'Karamzin monument','Ulyanovsk','Spasskaya',18,TRUE,'MONUMENT',9)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO SHOWPLACE (ID,NAME,CITY,STREET,BUILDING,FREE,CATEGORY,RATING) VALUES (2,'Spaso-Voznesenskiy sobor','Ulyanovsk','Minaeva',2,TRUE,'CHURCH',8)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO SHOWPLACE (ID,NAME,CITY,STREET,BUILDING,FREE,CATEGORY,RATING) VALUES (3,'Museum of aviations history','Ulyanovsk','Aviatsionnaya',20,FALSE,'MUSEUM',10)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO SHOWPLACE (ID,NAME,CITY,STREET,BUILDING,FREE,CATEGORY,RATING) VALUES (4,'House of Pioneers','Ulyanovsk','Minaeva',50,FALSE,'ARCHITECTURE',4)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO SHOWPLACE (ID,NAME,CITY,STREET,BUILDING,FREE,CATEGORY,RATING) VALUES (5,'Eternal flame','Ulyanovsk','Minaeva',52,TRUE,'MONUMENT',9)";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("---Items inserted");

            //уточнение данных
            stmt = c.createStatement();
            sql = "UPDATE SHOWPLACE set RATING = 5 where ID=2";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            System.out.println("---UPDATE done");

            //выборка данных
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SHOWPLACE where STREET = 'Minaeva' order by RATING DESC;");
                    while (rs.next()) {
                        int id = rs.getInt("ID");
                        String name = rs.getString("NAME");
                        String city = rs.getString("CITY");
                        String street = rs.getString("STREET");
                        int building = rs.getInt("BUILDING");
                        boolean free = rs.getBoolean("FREE");
                        String category = rs.getString("CATEGORY");
                        int rating = rs.getInt("RATING");

                        System.out.println(String.format("ID=%s NAME=%s CITY=%s STREET=%s BUILDING=%s FREE=%s CATEGORY=%s RATING=%s", id, name, city, street, building, free, category, rating));
                    }
                rs.close();
                stmt.close();
                c.commit();
                System.out.println("---Operation SELECT done");

            //выборка данных 2
            stmt = c.createStatement();
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM SHOWPLACE where STREET = 'Minaeva' order by NAME;");
            while (rs2.next()) {
                int id = rs2.getInt("ID");
                String name = rs2.getString("NAME");
                String city = rs2.getString("CITY");
                String street = rs2.getString("STREET");
                int building = rs2.getInt("BUILDING");
                boolean free = rs2.getBoolean("FREE");
                String category = rs2.getString("CATEGORY");
                int rating = rs2.getInt("RATING");

                System.out.println(String.format("ID=%s NAME=%s CITY=%s STREET=%s BUILDING=%s FREE=%s CATEGORY=%s RATING=%s", id, name, city, street, building, free, category, rating));
            }
            rs2.close();
            stmt.close();
            c.commit();
            System.out.println("---Operation SELECT2 done");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No driver for PostgreSQL found");
            cnfe.printStackTrace();
        }


        Showplace obelisk = new Showplace("Obelisk", new City("Ulyanovsk"), new Street("Minaeva"), 1, Boolean.TRUE, Category.MONUMENT, Rating.five);
        Showplace hiruki = new Showplace("Hiruki", new City("Ulyanovsk"), new Street("Goncharova"), 12, Boolean.FALSE, Category.RESTAURANT, Rating.four);
        Showplace kremlin = new Showplace("Kremlin", new City("Moskow"), new Street("Red Square"), 1, Boolean.TRUE, Category.MUSEUM, Rating.ten);
        Showplace halyava = new Showplace("Halyava", new City("Ulyanovsk"), new Street("Naberezhnaya reki Sviyagi"), 40, Boolean.TRUE, Category.MONUMENT, Rating.seven);
        //System.out.println(obelisk.getName() + " and his code - " + obelisk.hashCode());


        //чтение из файла/запись в файл
        String fileContent = ReadFile.readFile("E:\\Учеба\\database\\src\\com\\company\\input\\input.txt");
        WriteFile.writeFile(fileContent + " written by Valera", "E:\\Учеба\\database\\src\\com\\company\\output\\output.txt");

        //вывод на печать прочитанного из файла
        System.out.println(fileContent);


       
        //создаем массив

        List<Showplace> showplaceList = new ArrayList<Showplace>();


        //добавляем элементы в массив
        showplaceList.add(obelisk);
        showplaceList.add(hiruki);
        showplaceList.add(kremlin);
        showplaceList.add(halyava);


        //перебираем элементы итератором и выводим на печать

            Iterator iterator = showplaceList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            Iterator iterator1 = showplaceList.iterator();
            System.out.println("---Начало многопоточности");

            //Многопоточность
            Runnable task = () -> {

            while (iterator1.hasNext()) {

               System.out.println(Thread.currentThread().getName() + ":" + iterator1.next()+  ": " );
                            }
        };

        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        thread.start();
        thread1.start();

        System.out.println("Main has been finished");

        }


    }




