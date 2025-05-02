package com.example.matchmaking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheckController {
     @GetMapping("/")
    public String home() {
        return "Matchmaking Engine is running!";
    }
}
