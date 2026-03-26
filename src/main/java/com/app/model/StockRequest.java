package com.app.model;


import jakarta.persistence.*;
@Entity
public class StockRequest {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String productName;
   private int quantity;
   private String username;
   private String status; // PENDING, APPROVED, REJECTED
   public Long getId() {
       return id;
   }
   public String getProductName() {
       return productName;
   }
   public void setProductName(String productName) {
       this.productName = productName;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   public String getUsername() {
       return username;
   }
   public void setUsername(String username) {
       this.username = username;
   }
   public String getStatus() {
       return status;
   }
   public void setStatus(String status) {
       this.status = status;
   }
}