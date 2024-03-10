package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.entity.ShareDetails;
import com.arrow.sharemarketbackend.model.SummaryModel;
import com.arrow.sharemarketbackend.repository.ShareDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioSummaryService {

    private final ShareDetailsRepository shareDetailsRepository;

    @Autowired
    public PortfolioSummaryService(ShareDetailsRepository shareDetailsRepository) {
        this.shareDetailsRepository = shareDetailsRepository;
    }

    public List<SummaryModel> getAllStocks() {
        final List<ShareDetails> shareDetails = shareDetailsRepository.findAll();
        return shareDetails.stream().map(shareDetail -> new SummaryModel(shareDetail.getName(), shareDetail.getId(),
                        shareDetail.getQuantity(), shareDetail.getAveragePrice(),
                        shareDetail.getAveragePrice() * shareDetail.getQuantity())).toList();
    }

    public SummaryModel getStocksById(String indexName) {
        final Optional<ShareDetails> optional = shareDetailsRepository.findById(indexName);
        SummaryModel summaryModel = null;
        if (optional.isPresent()) {
            final ShareDetails shareDetail = optional.get();
            summaryModel =  new SummaryModel(shareDetail.getName(), shareDetail.getId(),
                    shareDetail.getQuantity(), shareDetail.getAveragePrice(),
                    shareDetail.getAveragePrice() * shareDetail.getQuantity());
        }
        return summaryModel;
    }
}
