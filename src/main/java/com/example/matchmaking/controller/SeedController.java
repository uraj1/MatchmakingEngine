package com.example.matchmaking.controller;
import com.example.matchmaking.model.userProfile;
import com.example.matchmaking.service.MatchmakingService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
public class SeedController {

    @Autowired
    private MatchmakingService matchmakingService;

    @GetMapping("/seed")
    public String seedData(@RequestParam(defaultValue = "1000") int count) {
        Faker faker = new Faker();
        List<String> interestPool = Arrays.asList("music", "art", "travel", "reading", "cooking", "sports", "gaming", "movies", "dancing", "tech");

        for (int i = 0; i < count; i++) {
            userProfile user = new userProfile();
            user.setId("user" + i);
            user.setAge(faker.number().numberBetween(18, 45));
            user.setGender(faker.options().option("M", "F"));
            user.setLat(Double.parseDouble(faker.address().latitude()));
            user.setLon(Double.parseDouble(faker.address().longitude()));
            Collections.shuffle(interestPool);
            user.setInterests(new HashSet<>(interestPool.subList(0, faker.number().numberBetween(2, 5))));
            matchmakingService.register(user);
        }

        return count + " users seeded successfully.";
    }
}
