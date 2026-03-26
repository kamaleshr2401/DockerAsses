package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Product;
import com.app.repo.ProductRepository;


@Service
public class ProductService {
   @Autowired
   ProductRepository repository;
   public Product addStock(Product product) {
       return repository.save(product);
   }
   public List<Product> getProducts() {
       return repository.findAll();
   }
}
