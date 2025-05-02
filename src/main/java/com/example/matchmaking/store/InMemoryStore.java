package com.example.matchmaking.store;

import com.example.matchmaking.model.userProfile;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStore {
    public static final Map<String, userProfile> profiles = new ConcurrentHashMap<>();
    public static final Map<String, Set<String>> geoIndex = new ConcurrentHashMap<>();
    public static final Map<String, List<String>> precomputedMatches = new ConcurrentHashMap<>();
}
