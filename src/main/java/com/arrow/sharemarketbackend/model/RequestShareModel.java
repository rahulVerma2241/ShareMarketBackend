package com.arrow.sharemarketbackend.model;

/**
    @author rahulverma

 */
public class RequestShareModel {

    // Current stock under user portfolio
    private Integer existingQuantity;

    // Current average price of the stock under portfolio
    private Double existingPrice;

    // Price of the stock as per market
    private Double currentPrice;

    // Company name of the stock
    private String companyName;

    // Price expected to reach
    private Double desiredPrice;

    // Price expected to reach to desired quantity
    private Integer desiredQuantity;

    public Integer getDesiredQuantity() {
        return desiredQuantity;
    }

    public void setDesiredQuantity(Integer desiredQuantity) {
        this.desiredQuantity = desiredQuantity;
    }

    public Integer getExistingQuantity() {
        return existingQuantity;
    }

    public void setExistingQuantity(Integer existingQuantity) {
        this.existingQuantity = existingQuantity;
    }

    public Double getExistingPrice() {
        return existingPrice;
    }

    public void setExistingPrice(Double existingPrice) {
        this.existingPrice = existingPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getDesiredPrice() {
        return desiredPrice;
    }

    public void setDesiredPrice(Double desiredPrice) {
        this.desiredPrice = desiredPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
