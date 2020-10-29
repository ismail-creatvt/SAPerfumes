package com.saperfumes.product;

public class Product {

    private int image;
    private int id;
    private String category;
    private String productName;
    private float productPrice;

    public Product(int id, String category, String productName, float productPrice, int image) {
        this.id = id;
        this.category = category;
        this.productName = productName;
        this.productPrice = productPrice;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

}
