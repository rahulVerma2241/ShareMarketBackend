package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.arrow.sharemarketbackend.model.ShareMarketDetails;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceAnalysisService {

    public ShareMarketModel priceDownAnalysisByPrice(RequestShareModel requestShareModel) {
        ShareMarketModel model = new ShareMarketModel();
        model.setCompanyName(requestShareModel.companyName());
        List<ShareMarketDetails> marketDetailsList = new ArrayList<>();
        Integer newQuan = requestShareModel.existingQuantity();
        Double averagePrice = requestShareModel.existingPrice();
        while (averagePrice >= requestShareModel.desiredPrice()) {
            averagePrice = ((averagePrice * newQuan) + requestShareModel.currentPrice())/(newQuan+1);
            newQuan++;
            ShareMarketDetails marketDetails = new ShareMarketDetails();
            marketDetails.setQuantity(newQuan);
            marketDetails.setCurrentPrice(averagePrice);
            marketDetails.setName(requestShareModel.companyName());
            marketDetailsList.add(marketDetails);
        }
        model.setShareMarketDetails(marketDetailsList);
        model.setTotalQuantity(model.getShareMarketDetails().size());
        model.setTotalInvestmentAmount(model.getTotalQuantity()* requestShareModel.currentPrice());
        return model;
    }

    public ShareMarketModel priceAnalysisByQuantity(RequestShareModel requestShareModel) {
        ShareMarketModel model = new ShareMarketModel();
        model.setCompanyName(requestShareModel.companyName());
        Integer newQuan = requestShareModel.existingQuantity();
        Double averagePrice = requestShareModel.existingPrice();
        Integer desiredQuantity = requestShareModel.desiredQuantity();
        List<ShareMarketDetails> marketDetailsList = new ArrayList<>();
        while( desiredQuantity > 0 ) {
            averagePrice = ((averagePrice * newQuan) + requestShareModel.currentPrice())/(newQuan+1);
            newQuan++;
            ShareMarketDetails marketDetails = new ShareMarketDetails();
            marketDetails.setQuantity(newQuan);
            marketDetails.setCurrentPrice(averagePrice);
            marketDetails.setName(requestShareModel.companyName());
            marketDetailsList.add(marketDetails);
            desiredQuantity--;
        }
        model.setShareMarketDetails(marketDetailsList);
        model.setTotalQuantity(model.getShareMarketDetails().size());
        model.setTotalInvestmentAmount(model.getTotalQuantity()* requestShareModel.currentPrice());
        return model;
    }



}
