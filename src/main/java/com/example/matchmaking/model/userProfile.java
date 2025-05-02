package com.example.matchmaking.model;

import java.util.HashSet;
import java.util.Set;

public class userProfile {
    private String id;
    private int age;
    private String gender;
    private double lat;
    private double lon;
    private Set<String> interests;
    private String geohash;
    private Set<String> blockedUsers = new HashSet<>();
    private Set<String> dislikedUsers = new HashSet<>();
    private Set<String> matchedUsers = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Set<String> getInterests() {
        return interests;
    }

    public void setInterests(Set<String> interests) {
        this.interests = interests;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    public Set<String> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(Set<String> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public Set<String> getDislikedUsers() {
        return dislikedUsers;
    }

    public void setDislikedUsers(Set<String> dislikedUsers) {
        this.dislikedUsers = dislikedUsers;
    }

    public Set<String> getMatchedUsers() {
        return matchedUsers;
    }

    public void setMatchedUsers(Set<String> matchedUsers) {
        this.matchedUsers = matchedUsers;
    }
    
}
