package com.example.model;

import androidx.annotation.NonNull;

public class Product {
    private int productID;
    private String productName;
    private String productPrice;

    @Override
    public String toString() {
        return  productID +
                "-" + productName +
                "-" + productPrice;
    }

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productID, String productName, String productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
