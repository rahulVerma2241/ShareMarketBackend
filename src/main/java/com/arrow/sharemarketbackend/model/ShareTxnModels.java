package com.arrow.sharemarketbackend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShareTxnModels(@NotNull String name,
                             @NotNull @NotBlank String indexName,
                             @NotNull Double purchaseQuantity,
                             @NotNull Double purchasePrice) {
}
