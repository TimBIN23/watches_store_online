package com.main.watchesstoreonline.models;

public class Offer {
    private int imageResId; // Resource ID for the offer image
    private String title;   // Title of the offer
    private String description; // Description of the offer
    private String discount; // Discount information

    // Constructor
    public Offer(int imageResId, String title, String description, String discount) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.discount = discount;
    }

    // Getters
    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDiscount() {
        return discount;
    }

}
