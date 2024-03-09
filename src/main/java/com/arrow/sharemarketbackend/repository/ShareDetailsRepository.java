package com.arrow.sharemarketbackend.repository;

import com.arrow.sharemarketbackend.entity.ShareDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareDetailsRepository extends JpaRepository<ShareDetails, String> {
}
