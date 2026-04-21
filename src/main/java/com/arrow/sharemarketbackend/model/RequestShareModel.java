package com.arrow.sharemarketbackend.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
    @author rahulverma

 */


public record RequestShareModel(@Positive Integer existingQuantity,
                                @Positive Double existingPrice ,
                                @Positive Double currentPrice,
                                @NotNull  String companyName ,
                                @Positive Double desiredPrice,
                                @Positive Integer desiredQuantity) {

}
