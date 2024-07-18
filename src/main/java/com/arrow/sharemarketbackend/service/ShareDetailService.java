package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.entity.ShareDetails;
import com.arrow.sharemarketbackend.model.ShareTxnModels;
import com.arrow.sharemarketbackend.repository.ShareDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShareDetailService {
    private final Logger log = LoggerFactory.getLogger(ShareDetailService.class);

    private final ShareDetailsRepository shareDetailsRepository;

    public ShareDetailService(ShareDetailsRepository shareDetailsRepository) {
        this.shareDetailsRepository = shareDetailsRepository;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveSummary(ShareTxnModels shareTxnModels){
        ShareDetails shareDetails ;
        final Optional<ShareDetails> optionalDetails = shareDetailsRepository.findById(shareTxnModels.indexName());
        shareDetails = optionalDetails.orElseGet(ShareDetails::new);
        log.info("shareDetails {}", shareDetails );
        shareDetails.setId(shareTxnModels.indexName());
        shareDetails.setName(shareTxnModels.name());
        double average = ((shareDetails.getQuantity() * shareDetails.getAveragePrice())
                + (shareTxnModels.purchasePrice() * shareTxnModels.purchaseQuantity()))
                / (shareDetails.getQuantity() + shareTxnModels.purchaseQuantity());
        shareDetails.setQuantity(shareDetails.getQuantity() + shareTxnModels.purchaseQuantity());
        log.info("average {} ", average);
        shareDetails.setAveragePrice(average);
        shareDetailsRepository.save(shareDetails);
    }
}
