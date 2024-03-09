package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.entity.ShareDetails;
import com.arrow.sharemarketbackend.entity.ShareTxn;
import com.arrow.sharemarketbackend.model.ShareTxnModels;
import com.arrow.sharemarketbackend.repository.ShareDetailsRepository;
import com.arrow.sharemarketbackend.repository.ShareTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class ShareDataSaverService {

    private final Logger log = LoggerFactory.getLogger(ShareDataSaverService.class);
    private final ShareTransactionRepository shareTransactionRepository;

    private final ShareDetailsRepository shareDetailsRepository;

    @Autowired
    public ShareDataSaverService(ShareTransactionRepository shareTransactionRepository,
                                 ShareDetailsRepository shareDetailsRepository) {
        this.shareTransactionRepository = shareTransactionRepository;
        this.shareDetailsRepository = shareDetailsRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveShareTransaction(ShareTxnModels shareTxnModels) {
        ShareTxn shareTxn = new ShareTxn();
        shareTxn.setName(shareTxnModels.name());
        shareTxn.setPrice(shareTxnModels.purchasePrice());
        shareTxn.setQuantity(shareTxnModels.purchaseQuantity());
        shareTxn.setTotalAmount(shareTxnModels.purchasePrice() * shareTxnModels.purchaseQuantity());
        shareTxn.setPurchaseDate(LocalDate.now());
        shareTransactionRepository.save(shareTxn);
        saveSummary(shareTxnModels);
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
