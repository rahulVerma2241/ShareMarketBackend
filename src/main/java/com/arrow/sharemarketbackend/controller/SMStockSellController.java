package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.model.RequestPriceSellModel;
import com.arrow.sharemarketbackend.model.SMProfitModel;
import com.arrow.sharemarketbackend.service.SellerPriceAnalyser;
import com.arrow.sharemarketbackend.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppConstant.SHARE_MARKET)
public class SMStockSellController {

    private SellerPriceAnalyser sellerPriceAnalyser;

    @Autowired
    public SMStockSellController(SellerPriceAnalyser sellerPriceAnalyser) {
        this.sellerPriceAnalyser = sellerPriceAnalyser;
    }


    public void setSellerPriceAnalyser(SellerPriceAnalyser sellerPriceAnalyser) {
        this.sellerPriceAnalyser = sellerPriceAnalyser;
    }

    @GetMapping("calculateProfit")
    public ResponseEntity<SMProfitModel> sellStockByPrice(@RequestBody RequestPriceSellModel requestPriceSellModel) {
        final SMProfitModel smProfitModel = sellerPriceAnalyser.calculateProfit(requestPriceSellModel);
        return ResponseEntity.ok(smProfitModel);
    }

    @GetMapping("calculateProfitByAmount")
    public ResponseEntity<List<SMProfitModel>> sellStockByPriceAmt(@RequestBody RequestPriceSellModel requestPriceSellModel) {
        return ResponseEntity.ok(sellerPriceAnalyser.calculateProfitByAmount(requestPriceSellModel));
    }
}
