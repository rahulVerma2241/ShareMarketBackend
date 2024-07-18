package com.arrow.sharemarketbackend.service;

import com.arrow.sharemarketbackend.entity.ShareTxn;
import com.arrow.sharemarketbackend.model.ShareTxnModels;
import com.arrow.sharemarketbackend.repository.ShareTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;


@Service
public class ShareDataSaverService {

    private final ShareTransactionRepository shareTransactionRepository;
    private final ShareDetailService shareDetailService;

    @Autowired
    public ShareDataSaverService(ShareTransactionRepository shareTransactionRepository,
                                 ShareDetailService shareDetailService) {
        this.shareTransactionRepository = shareTransactionRepository;
        this.shareDetailService = shareDetailService;
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
        shareDetailService.saveSummary(shareTxnModels);
    }


}
