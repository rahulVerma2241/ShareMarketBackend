package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.model.SummaryModel;
import com.arrow.sharemarketbackend.service.PortfolioSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("portfolio")
public class PortfolioController {

    private final PortfolioSummaryService portfolioSummaryService;

    @Autowired
    public PortfolioController(PortfolioSummaryService portfolioSummaryService) {
        this.portfolioSummaryService = portfolioSummaryService;
    }

    @GetMapping("summary")
    public ResponseEntity<List<SummaryModel>> getPortFolioDetails() {
        final List<SummaryModel> stocks = portfolioSummaryService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{shareIndexName}/portfolio")
    public ResponseEntity<SummaryModel> getPortfolioByName(@PathVariable("shareIndexName") String indexName) {
        final SummaryModel summaryModel = portfolioSummaryService.getStocksById(indexName);
        return summaryModel ==null ? ResponseEntity.noContent().build() : ResponseEntity.ok(summaryModel);
    }
}
