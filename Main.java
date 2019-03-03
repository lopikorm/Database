package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Showplace obelisk = new Showplace("Obelisk", "Ulyanovsk", "Minaeva", 1, Boolean.TRUE, Category.MONUMENT);
        System.out.println(obelisk + " and his code - " + obelisk.hashCode());

        String fileContent = readFile("E:\\Учеба\\database\\src\\com\\company\\input.txt");
        //writeFile(fileContent+ "written", "E:\\Учеба\\database\\src\\com\\company\\output.txt");
        System.out.println(fileContent);
        List<Area> areas = new ArrayList<Area>();
    }

    private static String readFile(String fileName) {
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



