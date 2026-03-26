package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.StockRequest;

@Repository
public interface StockRequestRepository extends JpaRepository<StockRequest, Long> {
}
