package com.dtk.ssoauthclient.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {
    @GetMapping("/protected")
    public ResponseEntity<String> getProtectedResource() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok("This is a protected resource. Welcome, " + username + "!");
    }

    @GetMapping("/public")
    public ResponseEntity<String> getPublicResource() {
        System.out.println("Accessing /api/public");
        return ResponseEntity.ok("This is a public resource. No authentication required.");
    }

}
