package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.StockRequest;
import com.app.repo.StockRequestRepository;
@Service
public class StockRequestService {
   @Autowired
   StockRequestRepository repository;
   // User sends stock request
   public StockRequest requestStock(StockRequest request) {
       request.setStatus("PENDING");
       return repository.save(request);
   }
   // Admin view all requests
   public List<StockRequest> getAllRequests() {
       return repository.findAll();
   }
   // Admin approve request
   public StockRequest approveRequest(Long id) {
       StockRequest req = repository.findById(id).get();
       req.setStatus("APPROVED");
       return repository.save(req);
   }
   // Admin reject request
   public StockRequest rejectRequest(Long id) {
       StockRequest req = repository.findById(id).get();
       req.setStatus("REJECTED");
       return repository.save(req);
   }
}
