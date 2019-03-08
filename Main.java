package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Showplace obelisk = new Showplace("Obelisk", "Ulyanovsk", "Minaeva", 1, Boolean.TRUE, Category.MONUMENT, 0);
        obelisk.setRating(9);
        Showplace hiruki = new Showplace("Hiruki","Ulyanovsk", "Goncharova", 12, Boolean.FALSE, Category.RESTAURANT, 0 );
        hiruki.setRating(8);
        //System.out.println(obelisk.getName() + " and his code - " + obelisk.hashCode());


        //чтение из файла классов
        String fileContent = readFile("E:\\Учеба\\database\\src\\com\\company\\input.txt");
        //writeFile(fileContent+ "written", "E:\\Учеба\\database\\src\\com\\company\\output.txt");

        //вывод на печать прочитанного из файла
        System.out.println(fileContent);


      /** String[] strings = fileContent.split(";");
        for(String currentString : strings) {
           // Showplace() = currentString;
            System.out.println(currentString);
        }*/

        //создаем массив
      List<Showplace> showplaceList = new ArrayList<Showplace>();

        //добавляем элементы в массив
        showplaceList.add(obelisk);
        showplaceList.add (hiruki);

        //перебираем элементы итератором и выводим на печать

        Iterator iterator = showplaceList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next( ));
        }

           }
    //задаем метод readFile для чтения из файла

    public static String readFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        // FileInputStream inputStream = null;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int intSymbol = inputStream.read();
                char symbol = (char)intSymbol;
                //System.out.println(intSymbol);
                result.append(symbol);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return result.toString();
    }
        }



