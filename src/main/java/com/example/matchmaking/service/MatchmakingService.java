package com.example.matchmaking.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.matchmaking.store.InMemoryStore;
import com.example.matchmaking.util.GeoHashUtil;
import com.example.matchmaking.util.MatchScorer;

import com.example.matchmaking.model.userProfile;

@Service
public class MatchmakingService {
     public void register(userProfile user) {
            String geohash = GeoHashUtil.getGeohash(user.getLat(), user.getLon());
            user.setGeohash(geohash);
            InMemoryStore.profiles.put(user.getId(), user);
            InMemoryStore.geoIndex.computeIfAbsent(geohash, k -> ConcurrentHashMap.newKeySet()).add(user.getId());
    
            // Precompute top 5 matches
            List<userProfile> candidates = InMemoryStore.geoIndex.getOrDefault(geohash, Collections.emptySet())
                    .stream()
                    .map(InMemoryStore.profiles::get)
                    .filter(candidate -> !candidate.getId().equals(user.getId()))
                    .filter(candidate -> !user.getBlockedUsers().contains(candidate.getId()))
                    .filter(candidate -> !user.getDislikedUsers().contains(candidate.getId()))
                    .filter(candidate -> !user.getMatchedUsers().contains(candidate.getId()))
                    .collect(Collectors.toList());
    
            PriorityQueue<userProfile> pq = new PriorityQueue<>(5, Comparator.comparingDouble(u -> -MatchScorer.score(user, u)));
            pq.addAll(candidates);
    
            List<String> topMatches = pq.stream()
                    .limit(5)
                    .map(userProfile::getId)
                    .collect(Collectors.toList());
    
            InMemoryStore.precomputedMatches.put(user.getId(), topMatches);
        }
    
        public List<userProfile> getMatches(String userId) {
            List<String> matchIds = InMemoryStore.precomputedMatches.getOrDefault(userId, Collections.emptyList());
            return matchIds.stream()
                    .map(InMemoryStore.profiles::get)
                    .collect(Collectors.toList());
        }
    }

