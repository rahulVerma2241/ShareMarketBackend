package com.arrow.sharemarketbackend.model;

 public record RequestPriceSellModel(String stockName, Double existingPrice, Double existingQuantity, Double todayPrice,
                                     Double priceByIncrement, Integer incrementCounter) {

}
