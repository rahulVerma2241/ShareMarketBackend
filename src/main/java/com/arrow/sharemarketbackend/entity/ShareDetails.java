package com.arrow.sharemarketbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio_details")
public class ShareDetails {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private Double quantity;
    @Column
    private Double averagePrice;

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
        return quantity==null ? 0.0 : quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getAveragePrice() {
        return averagePrice == null ? 0.0 : averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "ShareDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
