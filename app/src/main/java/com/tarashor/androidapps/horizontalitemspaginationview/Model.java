package com.tarashor.androidapps.horizontalitemspaginationview;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Taras on 12.02.2018.
 */

public class Model {
    private List<Item> items = new ArrayList<>();
    private boolean isAllDataLoaded;
    private int itemsCount;
    private final int itemsPerPage;

    public Model(int itemsCount, int pagesCount) {
        this.itemsCount = itemsCount;
        this.itemsPerPage = itemsCount / pagesCount;
        items = new ArrayList<>();
        isAllDataLoaded = false;
    }

    public void clearItems() {
        items.clear();
        isAllDataLoaded = true;
    }

    public void resetIsAllDataLoaded(){
        isAllDataLoaded = false;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isAllDataLoaded() {
        return isAllDataLoaded;
    }

    public void generateNextPage() {
        Random randomRed = new Random();
        Random randomBlue = new Random();
        Random randomGreen = new Random();
        List<Item> itemsNextPage = new ArrayList<>();
        for(int i = 0; i < itemsPerPage; i++){
            itemsNextPage.add(new Item(Color.argb(255, randomRed.nextInt(256), randomGreen.nextInt(256), randomBlue.nextInt(256))));
        }

        items.addAll(itemsNextPage);

        if (items.size() >= itemsCount)
            isAllDataLoaded = true;
    }
}
