package com.main.watchesstoreonline.models;

public class BannerItem {
    private int imageResource;
    private String title;
    private String description;

    public BannerItem(int imageResource, String title, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageRes() {
        return imageResource;
    }
}
