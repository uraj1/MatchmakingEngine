package com.example.matchmaking.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.matchmaking.service.MatchmakingService;
import com.example.matchmaking.model.userProfile;

@RestController
public class ProfileController {
     @Autowired
    private MatchmakingService matchmakingService;

    @PostMapping("/profiles")
    public String registerProfile(@RequestBody userProfile user) {
        matchmakingService.register(user);
        return "User registered successfully.";
    }

    @GetMapping("/match/{id}")
    public List<userProfile> getMatches(@PathVariable String id) {
        return matchmakingService.getMatches(id);
    }
}
