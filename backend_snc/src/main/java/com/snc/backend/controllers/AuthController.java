package com.snc.backend.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.snc.backend.services.OAuth2AuthService;

import java.util.Map;
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final OAuth2AuthService authService;

    public AuthController(OAuth2AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> response = authService.authenticate(username, password);
        return ResponseEntity.ok(response);
    }
    
}
