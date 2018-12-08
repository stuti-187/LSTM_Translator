package com.example.kanika.indilens;

/**
 * Created by Kanika on 5/7/17.
 */


public class Items {

    private final String name;
    private final int imgId;

    public Items(String name, int id) {
        this.name = name;
        this.imgId = id;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

}
