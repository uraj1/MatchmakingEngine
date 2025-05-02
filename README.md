# 💘 In-Memory Matchmaking Engine – Java + Spring Boot

A high-performance, scalable in-memory matchmaking engine for a dating app. This system enables user registration and real-time matchmaking based on geohashing, location proximity, age similarity, and shared interests — all with precomputed match scores to ensure near-instant lookup times.

---

## 🚀 Features

- ✅ User registration with geohash quadrant assignment (precision 5)
- ✅ Real-time matchmaking endpoint (`GET /match/{id}`)
- ✅ Scoring based on:
  - Shared interests
  - Age similarity
  - Location proximity (via geohash)
- ✅ Exclusion support:
  - Blocked users
  - Disliked users
  - Already matched users
- ✅ In-memory storage (no database used)
- ✅ Precomputation of match scores at registration
- ✅ Modular, extensible structure for adding future filters (e.g., gender preference)

---

## 📐 Architecture

### Key Components

- **`userProfile`**: Java class representing a user's data (ID, age, gender, location, interests, exclusions, etc.)
- **`MatchmakingService`**: Core logic for registering users, computing match scores, and retrieving top 5 matches.
- **`GeoHashUtils`**: Utility to encode latitude/longitude into GeoHash codes using precision level 5 for proximity filtering.
- **`ProfileController`**: REST controller to handle registration and matchmaking API endpoints.

### Data Structures Used

- `ConcurrentHashMap<String, userProfile>` for fast in-memory access of users by ID.
- `Map<String, Set<userProfile>>` for geohash-based indexing of users by region.
- `Map<String, List<MatchScore>>` for storing precomputed match scores for every user (sorted by score).

### Matching Algorithm

- **Shared Interests**: +10 points for each shared interest.
- **Age Difference**: Linear penalty; the greater the difference, the lower the score.
- **Proximity**: Only users in the **same geohash quadrant (precision 5)** are considered.

---

## 📡 API Endpoints

### 1. Register a User
- **POST** `/profiles`
- **Payload:**
```json
{
  "id": "user123",
  "name": "Alice",
  "age": 25,
  "gender": "F",
  "lat": 28.6139,
  "lon": 77.2090,
  "interests": ["music", "travel", "art"]
}
