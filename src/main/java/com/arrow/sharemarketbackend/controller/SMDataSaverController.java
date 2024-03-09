package com.arrow.sharemarketbackend.controller;

import com.arrow.sharemarketbackend.model.ShareTxnModels;
import com.arrow.sharemarketbackend.service.ShareDataSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. Save the share purchase data
 * 2. Store the transaction
 * 3.
 */
@RestController
@RequestMapping("/sharemarket")
public class SMDataSaverController {

    @Autowired
    ShareDataSaverService shareDataSaverService;
    @PostMapping("/sharetxn/data/")
    public ResponseEntity<String> saveShareTxnData(@RequestBody ShareTxnModels shareTxnModels) {
        shareDataSaverService.saveShareTransaction(shareTxnModels);
        return ResponseEntity.accepted().build();
    }
}
