package com.app.model;

import jakarta.persistence.*;

@Entity
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private Long id;
   private String productName;
   private int quantity;
   public Long getId() { return id; }
   public String getProductName() { return productName; }
   public void setProductName(String productName) {
       this.productName = productName;
   }
   
   public int getQuantity() { return quantity; }
   
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
}
