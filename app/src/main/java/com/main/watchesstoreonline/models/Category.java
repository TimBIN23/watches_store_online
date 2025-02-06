package com.main.watchesstoreonline.models;

public class Category {
    private final int imageResId;
    private final String name;
    public Category(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}

