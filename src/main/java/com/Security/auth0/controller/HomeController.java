package com.Security.auth0.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello Home!";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal OidcUser user) {
        String name = user.getFullName();
        String email = user.getEmail();
        return "Welcome, " + name + " (" + email + ")";
    }

    @GetMapping("/logout")
    public String logoutSuccess() {
        return "You’ve been logged out successfully!";
    }



}
