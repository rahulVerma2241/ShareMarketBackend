package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.helper.JwtHelper;
import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import com.arrow.sharemarketbackend.service.PriceAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("sharemarket")

public class SMPriceDownControlller {

    private final Logger logger = LoggerFactory.getLogger(SMPriceDownControlller.class);
    @Autowired
    private PriceAnalysisService priceAnalysisService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    public void setPriceAnalysisService(PriceAnalysisService priceAnalysisService) {
        this.priceAnalysisService = priceAnalysisService;
    }

    @GetMapping("/pricedown")
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public ResponseEntity<ShareMarketModel> priceDown(@RequestBody RequestShareModel shareModel,
                                                      @AuthenticationPrincipal Jwt jwt) {
        logger.info(" Jwt Token :: {}" , jwt.getTokenValue());
        logger.info(" In the price down calculator with {} " , shareModel);
        ShareMarketModel model;
        try {
           model = priceAnalysisService.priceDownAnalysisByPrice(shareModel);
        }
        catch (Exception e) {
            logger.error("Error occurred in application ::: >> " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        logger.info(" Exited  price down calculator with {} " , shareModel);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/priceByQuantity")
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public ResponseEntity<ShareMarketModel> priceByQuantity(@RequestBody RequestShareModel shareModel,
                                                            @AuthenticationPrincipal Jwt jwt) {
        logger.info("User {} has logged and email : {}" , jwtHelper.name(jwt), jwtHelper.userEmail(jwt));
        logger.info(" In the price by quantity calculator with {} " , shareModel);
        ShareMarketModel model;
        try {
            model = priceAnalysisService.priceAnalysisByQuantity(shareModel);
        }
        catch (Exception e) {
            logger.error("Error occurred in application ::: >> " + e);
            e.printStackTrace();
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
