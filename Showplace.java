package com.company;

public class Showplace implements Cloneable{
    private String name;
    private String city;
    private String street;
    private Integer building;
    private Boolean free;
    private Category category;
    private int rating;

    public Showplace(String name, String city, String street, Integer building, Boolean free, Category category, int rating ) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.building = building;
        this.free = free;
        this.category = category;
        this.rating = rating;
        }

        public Showplace(){

        }
    // в методе setRating устанавливаем ограничения на ввод от 1 до 10
    public void setRating(int rating){

        if ((rating>=1)&(rating<=10)){
            this.rating = rating;
        } else {
            System.out.println("Ошибка!Рейтинг должен быть в диапазоне от 1 до 10!");
        }
    }
    public String toString() {

       String result = this.getName() != null ? this.getName() + " " : "";

       result += this.getCity() != null ? this.getCity() + " " : "";
       result += this.getStreet() != null ? this.getStreet() + " " : "";
       result += this.getBuilding() != null ? this.getBuilding() + " " : "";
       result += this.getFree() != null ? this.getFree() + " " : "";
       result += this.getCategory() != null ? this.getCategory() + " " : "";
       result += this.getRating() != null ? this.getRating() + " " : "";

        return result;
    }



    public String getName() {
        return name;
    }

    public String getCity() { return city; }

    public String getStreet() { return street; }

    public Integer getBuilding() { return building; }

    public Boolean getFree() { return free; }

    public Enum getCategory() { return category; }

    public Integer getRating() { return rating; }




}
