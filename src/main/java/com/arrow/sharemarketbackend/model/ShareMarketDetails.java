package com.arrow.sharemarketbackend.model;

public class ShareMarketDetails {
    private String name;
    private Double currentPrice;
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShareMarketModel{" + "name='" + name + '\'' + ", currentPrice=" + currentPrice + ", quantity=" + quantity + '}';
    }
}
