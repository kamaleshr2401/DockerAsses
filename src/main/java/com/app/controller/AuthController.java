package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.model.User;
import com.app.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   UserRepository repo;
   @PostMapping("/login")
   public User login(@RequestBody User user) {
       User existing = repo.findByUsername(user.getUsername());
       if(existing != null) {
           return existing;
       }
       return null;
   }
}
