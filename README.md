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
- ✅ In-memory storage using singleton store class
- ✅ Precomputation of match scores at registration
- ✅ Modular, extensible structure for adding future filters (e.g., gender preference)
- ✅ Seed controller to generate dummy profiles
- ✅ Health check endpoint for service monitoring

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
