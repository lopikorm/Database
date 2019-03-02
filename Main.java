package com.company;

public class Main {

    public static void main(String[] args) {
        Showplace obelisk = new Showplace("Obelisk", "Ulyanovsk", "Minaeva", 1, Boolean.TRUE, Category.MONUMENT);
        System.out.println(obelisk + " and his code - " + obelisk.hashCode());

    }

}