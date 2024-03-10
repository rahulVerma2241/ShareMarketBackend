package com.arrow.sharemarketbackend.model;

public record SummaryModel(String name, String indexName, Double quantity, Double averagePrice,
                           Double totalAmount) {
}
