package com.tarashor.androidapps.horizontalitemspaginationview;

/**
 * Created by Taras on 12.02.2018.
 */

public class Item {
    private int color;
    private String name;

    public Item(int color) {
        this.color = color;
        this.name = String.valueOf(color);
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
