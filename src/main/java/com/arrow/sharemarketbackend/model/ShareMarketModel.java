package com.arrow.sharemarketbackend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ShareMarketModel {

    private List<ShareMarketDetails> shareMarketDetails;

    private Double totalInvestmentAmount;

    private Integer totalQuantity;

    private String companyName ;

    private Double stockPriceDiff;

}
