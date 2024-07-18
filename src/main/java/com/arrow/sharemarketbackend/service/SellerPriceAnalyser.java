package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.model.RequestPriceSellModel;
import com.arrow.sharemarketbackend.model.SMProfitModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class SellerPriceAnalyser {

    private final Logger logger = LoggerFactory.getLogger(SellerPriceAnalyser.class);

    public SMProfitModel calculateProfit(RequestPriceSellModel requestPriceSellModel) {
        logger.info("In the calculateProfit for {} ", requestPriceSellModel);
        Double profit = requestPriceSellModel.todayPrice() - requestPriceSellModel.existingPrice() ;
        profit*= requestPriceSellModel.existingQuantity();
        logger.info("Profit calculated for {} is {}" , requestPriceSellModel.stockName() ,profit);
        double percetage = profit/ (requestPriceSellModel.existingPrice() * requestPriceSellModel.existingQuantity());
        return new SMProfitModel(profit , percetage*100 ,requestPriceSellModel);
    }

    public List<SMProfitModel> calculateProfitByAmount(RequestPriceSellModel requestPriceSellModel) {
        List<SMProfitModel> smProfitModels = new ArrayList<>();
        IntStream.range(0, requestPriceSellModel.incrementCounter()).forEach(counter -> {
            logger.info("In the calculateProfit for {} ", requestPriceSellModel);
            Double profit = requestPriceSellModel.todayPrice()+ (counter*requestPriceSellModel.priceByIncrement()) - requestPriceSellModel.existingPrice() ;
            profit *= requestPriceSellModel.existingQuantity();
            logger.info("Profit calculated for {} is {}" , requestPriceSellModel.stockName() ,profit);
            double percentage = profit/(requestPriceSellModel.existingPrice() * requestPriceSellModel.existingQuantity());
            RequestPriceSellModel requestPriceSellModel1 = new RequestPriceSellModel(requestPriceSellModel.stockName(), requestPriceSellModel.existingPrice(),
                    requestPriceSellModel.existingQuantity(), requestPriceSellModel.todayPrice()+ (counter* requestPriceSellModel.priceByIncrement()),
                    requestPriceSellModel.priceByIncrement(), requestPriceSellModel.incrementCounter());
            smProfitModels.add(new SMProfitModel(profit , percentage * 100 ,requestPriceSellModel1)) ;
        });
        return smProfitModels;
    }
}
