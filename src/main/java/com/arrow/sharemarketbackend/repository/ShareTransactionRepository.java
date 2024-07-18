package com.arrow.sharemarketbackend.repository;

import com.arrow.sharemarketbackend.entity.ShareTxn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareTransactionRepository extends JpaRepository<ShareTxn , String> {
}
