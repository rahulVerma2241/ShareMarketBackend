package com.arrow.sharemarketbackend.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

/**
    @author rahulverma

 */


public record RequestShareModel(@Positive Integer existingQuantity,
                                @Positive Double existingPrice ,
                                @Positive Double currentPrice,
                                @NotNull  String companyName ,
                                @PositiveOrZero Double desiredPrice,
                                @Positive Integer desiredQuantity) {

}
