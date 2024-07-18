package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import com.arrow.sharemarketbackend.service.PriceAnalysisService;
import com.arrow.sharemarketbackend.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(AppConstant.SHARE_MARKET)
public class SMPriceDownController {

    private final Logger logger = LoggerFactory.getLogger(SMPriceDownController.class);

    private PriceAnalysisService priceAnalysisService;

    @Autowired
    public void setPriceAnalysisService(PriceAnalysisService priceAnalysisService) {
        this.priceAnalysisService = priceAnalysisService;
    }

    @GetMapping("/pricedown")
    public ResponseEntity<ShareMarketModel> priceDown(@RequestBody RequestShareModel shareModel) {
        logger.info(" In the price down calculator with {} " , shareModel);
        ShareMarketModel model;
        try {
           model = priceAnalysisService.priceDownAnalysisByPrice(shareModel);
        }
        catch (Exception e) {
            logger.error("Error occurred in application ::: >> " , e);
            return ResponseEntity.internalServerError().build();
        }
        logger.info(" Exited  price down calculator with {} " , shareModel);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/priceByQuantity")
    public ResponseEntity<ShareMarketModel> priceByQuantity(@RequestBody RequestShareModel shareModel) {
        logger.info(" In the price by quantity calculator with {} " , shareModel);
        ShareMarketModel model;
        try {
            model = priceAnalysisService.priceAnalysisByQuantity(shareModel);
        }
        catch (Exception e) {
            logger.error("Error occurred in application ::: >> " , e);
            return ResponseEntity.internalServerError().build();
        }
        logger.info(" Exited the price by quantity calculator with {} " , shareModel);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/api/data")
    public ResponseEntity<String> getApiName() {
        return ResponseEntity.ok("SM Price Controller" );
    }



}
