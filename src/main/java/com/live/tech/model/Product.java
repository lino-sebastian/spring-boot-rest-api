package com.live.tech.model;

import java.util.Objects;

public class Product {
    private String productId;
    private String productName;
    private String productDes;

    public Product(String productId, String productName, String productDes) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProductDes(), product.getProductDes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProductDes());
    }
}
