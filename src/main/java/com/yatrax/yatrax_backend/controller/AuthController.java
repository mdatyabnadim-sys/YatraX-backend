package com.yatrax.yatrax_backend.controller;

import com.yatrax.yatrax_backend.model.User;
import com.yatrax.yatrax_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired private UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email already exists"));
        }
        User saved = userRepo.save(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> found = userRepo.findByEmail(user.getEmail());
        if (found.isPresent() && found.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(found.get());
        }
        return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
    }
}
