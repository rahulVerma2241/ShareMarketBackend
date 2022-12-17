package com.arrow.sharemarketbackend.model;

/**
    @author rahulverma

 */


public record RequestShareModel( Integer existingQuantity, Double existingPrice ,Double currentPrice,
                           String companyName ,Double desiredPrice,Integer desiredQuantity) {

}
