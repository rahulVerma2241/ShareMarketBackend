package com.arrow.sharemarketbackend.model;

import java.util.List;

public class ShareMarketModel {

    private List<ShareMarketDetails> shareMarketDetails;

    private Double totalInvestmentAmount;

    private Integer totalQuantity;

    private String companyName ;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<ShareMarketDetails> getShareMarketDetails() {
        return shareMarketDetails;
    }

    public void setShareMarketDetails(List<ShareMarketDetails> shareMarketDetails) {
        this.shareMarketDetails = shareMarketDetails;
    }

    public Double getTotalInvestmentAmount() {
        return totalInvestmentAmount;
    }

    public void setTotalInvestmentAmount(Double totalInvestmentAmount) {
        this.totalInvestmentAmount = totalInvestmentAmount;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
