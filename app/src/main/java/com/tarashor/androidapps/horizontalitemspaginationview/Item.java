package com.tarashor.androidapps.horizontalitemspaginationview;

/**
 * Created by Taras on 12.02.2018.
 */

public class Item {
    private int color;
    private String name;
    private double heightCof;

    public Item(int color, double heightCof) {
        this.color = color;
        this.name = String.valueOf(color);
        this.heightCof = heightCof;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double getHeightCof() {
        return heightCof;
    }
}
