package com.example.restaurantvago;

public class MenuItems {

    private String name;
    private int pic;
    private String lorem = "\n \nLorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consequat lacus ut egestas vehicula. Aliquam ut sagittis neque.";

    public MenuItems(String name, int pic) {
        this.name = name + lorem;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }


    public int getPic(){
        return pic;
    }

}