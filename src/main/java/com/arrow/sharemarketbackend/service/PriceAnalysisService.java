package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.arrow.sharemarketbackend.model.ShareMarketDetails;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceAnalysisService {

    Logger logger = LoggerFactory.getLogger(PriceAnalysisService.class);

    public ShareMarketModel priceDownAnalysisByPrice(RequestShareModel requestShareModel) {
        ShareMarketModel model = new ShareMarketModel();
        model.setCompanyName(requestShareModel.getCompanyName());
        List<ShareMarketDetails> marketDetailsList = new ArrayList<>();
        Integer newQuan = requestShareModel.getExistingQuantity();
        Double averagePrice = requestShareModel.getExistingPrice();
        while (averagePrice >= requestShareModel.getDesiredPrice()) {
            ++newQuan;
            averagePrice = ((averagePrice * newQuan) + requestShareModel.getCurrentPrice())/newQuan;
            logger.info( requestShareModel.getCompanyName(), newQuan , averagePrice ,"Share :: {0}   Quantity :: {1}  Price:: {2}");
            ShareMarketDetails marketDetails = new ShareMarketDetails();
            marketDetails.setQuantity(newQuan);
            marketDetails.setCurrentPrice(averagePrice);
            marketDetails.setName(requestShareModel.getCompanyName());
            marketDetailsList.add(marketDetails);
        }
        model.setShareMarketDetails(marketDetailsList);
        return model;
    }

    public ShareMarketModel priceAnalysisByQuantity(RequestShareModel requestShareModel) {
        ShareMarketModel model = new ShareMarketModel();
        model.setCompanyName(requestShareModel.getCompanyName());
        Integer newQuan = requestShareModel.getExistingQuantity();
        Double averagePrice = requestShareModel.getExistingPrice();
        Integer desiredQuantity = requestShareModel.getDesiredQuantity();
        List<ShareMarketDetails> marketDetailsList = new ArrayList<>();
        while( desiredQuantity > 0 ) {
            ++newQuan;
            averagePrice = ((averagePrice * newQuan) + requestShareModel.getCurrentPrice())/newQuan;
            logger.info( requestShareModel.getCompanyName(), newQuan , averagePrice ,"Share :: {0}   Quantity :: {1}  Price:: {2}");
            ShareMarketDetails marketDetails = new ShareMarketDetails();
            marketDetails.setQuantity(newQuan);
            marketDetails.setCurrentPrice(averagePrice);
            marketDetails.setName(requestShareModel.getCompanyName());
            marketDetailsList.add(marketDetails);

            desiredQuantity--;
        }
        model.setShareMarketDetails(marketDetailsList);
        return model;
    }


}
