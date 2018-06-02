package com.sabziwale.sabziwale;

public class Vegetables {


    private String image;
    private String veg_name;
    private Double veg_price;

    public Vegetables() {
    }

    public Vegetables(String image, String veg_name, Double veg_price) {
        this.image = image;
        this.veg_name = veg_name;
        this.veg_price = veg_price;
    }

    public String getImage() {
        return image;
    }

    public String getVeg_name() {
        return veg_name;
    }

    public Double getVeg_price() {
        return veg_price;
    }

}
