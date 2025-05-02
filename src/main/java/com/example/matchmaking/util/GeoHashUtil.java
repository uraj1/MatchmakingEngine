package com.example.matchmaking.util;
import com.github.davidmoten.geo.GeoHash;

public class GeoHashUtil {
    public static String getGeohash(double lat, double lon) {
        return GeoHash.encodeHash(lat, lon, 5); // Precision 5
    }
}
