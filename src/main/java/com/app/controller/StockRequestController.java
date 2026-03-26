package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.StockRequest;
import com.app.service.StockRequestService;
@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:5173")
public class StockRequestController {
   @Autowired
   StockRequestService service;
   @GetMapping("/all")
   public List<StockRequest> getAllRequests(){
       return service.getAllRequests();
   }
   @PostMapping("/request")
   public StockRequest requestStock(@RequestBody StockRequest request){
       return service.requestStock(request);
   }
   @PutMapping("/approve/{id}")
   public StockRequest approve(@PathVariable Long id){
       return service.approveRequest(id);
   }
   @PutMapping("/reject/{id}")
   public StockRequest reject(@PathVariable Long id){
       return service.rejectRequest(id);
   }
}