package com.example.matchmaking.util;

import java.util.HashSet;
import java.util.Set;

import com.example.matchmaking.model.userProfile;

public class MatchScorer {
     public static double score(userProfile a, userProfile b) {
        double ageScore = 1.0 - Math.abs(a.getAge() - b.getAge()) / 50.0;
        double interestScore = jaccard(a.getInterests(), b.getInterests());
        return 0.6 * interestScore + 0.4 * ageScore;
    }

    private static double jaccard(Set<String> s1, Set<String> s2) {
        Set<String> inter = new HashSet<>(s1);
        inter.retainAll(s2);
        Set<String> union = new HashSet<>(s1);
        union.addAll(s2);
        return union.isEmpty() ? 0 : (double) inter.size() / union.size();
    }
}
