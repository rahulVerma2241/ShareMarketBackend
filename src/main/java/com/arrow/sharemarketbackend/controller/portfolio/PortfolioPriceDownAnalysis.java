package com.arrow.sharemarketbackend.controller.portfolio;

import com.arrow.sharemarketbackend.model.PortfolioMarketModel;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import com.arrow.sharemarketbackend.service.PortfolioSummaryService;
import com.arrow.sharemarketbackend.util.AppConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstant.PORTFOILO)
public class PortfolioPriceDownAnalysis {

    private final PortfolioSummaryService portfolioSummaryService;

    public PortfolioPriceDownAnalysis(PortfolioSummaryService portfolioSummaryService) {
        this.portfolioSummaryService = portfolioSummaryService;
    }

    @GetMapping("/priceByQuantity")
    public ResponseEntity<ShareMarketModel> priceByQuantity(@RequestBody PortfolioMarketModel shareModel) {
        ShareMarketModel shareMarketModel = null;
        shareMarketModel = portfolioSummaryService.priceDownAnalysis(shareModel);
        return ResponseEntity.ok(shareMarketModel);
    }
}
