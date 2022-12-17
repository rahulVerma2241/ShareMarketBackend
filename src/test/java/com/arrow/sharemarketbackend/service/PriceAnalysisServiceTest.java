package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.model.RequestShareModel;
import com.arrow.sharemarketbackend.model.ShareMarketModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PriceAnalysisServiceTest {

    private RequestShareModel requestShareModel;
    @InjectMocks
    private PriceAnalysisService service;

    @Test
    @DisplayName("Price down test cases")
    public void givenPriceOfStockAndQuantity_whenCheckForDesiredPrice_thenRetunQuantity() {
        requestShareModel = new RequestShareModel(42,438.0,421.6,
                "Tata Motors",428.0 , 0);
        final ShareMarketModel shareMarketModel = service.priceDownAnalysisByPrice(requestShareModel);
        assertEquals(shareMarketModel.getShareMarketDetails().size(), 66);
    }

    @Test
    @DisplayName("Price down analysis with quantity test cases")
    public void givenQuantity_whenCheckForQuantity_thenRetunPrice() {
        requestShareModel = new RequestShareModel(42,438.0,421.6,
                "Tata Motors",428.0 , 66);
        final ShareMarketModel shareMarketModel = service.priceAnalysisByQuantity(requestShareModel);
        assertEquals(shareMarketModel.getTotalInvestmentAmount(), 66*428);
    }
}
