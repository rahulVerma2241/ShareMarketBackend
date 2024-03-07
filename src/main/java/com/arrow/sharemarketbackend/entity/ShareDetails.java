package com.arrow.sharemarketbackend.entity;

import jakarta.persistence.Transient;

import java.util.List;

public class ShareDetails {

    private String id;

    private String name;

    private Double quantity;

    private Double averagePrice;

    @Transient
    private Double totalPrice;

    private List<ShareTxn> shareTxns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ShareTxn> getShareTxns() {
        return shareTxns;
    }

    public void setShareTxns(List<ShareTxn> shareTxns) {
        this.shareTxns = shareTxns;
    }

    @Override
    public String toString() {
        return "ShareDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", averagePrice=" + averagePrice +
                ", totalPrice=" + totalPrice +
                ", shareTxns=" + shareTxns +
                '}';
    }
}
