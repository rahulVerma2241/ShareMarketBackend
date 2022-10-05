package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import com.arrow.sharemarketbackend.service.PriceAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("sharemarket")
public class SMPriceDownControlller {
    PriceAnalysisService priceAnalysisService;

    @Autowired
    public void setPriceAnalysisService(PriceAnalysisService priceAnalysisService) {
        this.priceAnalysisService = priceAnalysisService;
    }

    @GetMapping("/pricedown")
    public ResponseEntity<ShareMarketModel> priceDown(@RequestBody RequestShareModel shareModel) {
        ShareMarketModel model;
        try {
           model = priceAnalysisService.priceDownAnalysisByPrice(shareModel);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(model);
    }

    @GetMapping("/priceByQuantity")
    public ResponseEntity<ShareMarketModel> priceByQuantity(@RequestBody RequestShareModel shareModel) {
        ShareMarketModel model;
        try {
            model = priceAnalysisService.priceDownAnalysisByPrice(shareModel);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(model);
    }

}
