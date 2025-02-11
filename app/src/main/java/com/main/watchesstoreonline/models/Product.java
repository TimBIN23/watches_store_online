package com.main.watchesstoreonline.models;

public class Product {
    private String name;
    private int imageResId;
    private double price;
    private double originalPrice;
    private float rating;
    private int reviewCount;
    private int discount;
    private boolean isWishlisted;

    public Product(String name, int imageResId, double price, double originalPrice, float rating, int reviewCount, int discount, boolean isWishlisted) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
        this.originalPrice = originalPrice;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.discount = discount;
        this.isWishlisted = isWishlisted;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public double getPrice() { return price; }
    public double getOriginalPrice() { return originalPrice; }
    public float getRating() { return rating; }
    public int getReviewCount() { return reviewCount; }
    public int getDiscount() { return discount; }
    public boolean isWishlisted() { return isWishlisted; }
}

