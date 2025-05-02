💘 In-Memory Matchmaking Engine
A high-performance in-memory matchmaking engine for a dating app. This system supports profile registration and real-time top-5 matchmaking based on geolocation, interest similarity, and age proximity—without using a persistent database.

🚀 Features
In-memory user profile storage.

Geohash-based quadrant filtering for locality-aware matchmaking.

Real-time top-5 matchmaking based on:

Location proximity

Age similarity

Shared interests

Profile exclusions: blocked, disliked, or already matched users.

Precomputed match scores for constant-time retrieval.

Health check endpoint.

Dummy data seeding endpoint.

🧠 Architecture Overview
1. Controller Layer (controller/)
ProfileController: Handles profile creation and match retrieval.

SeedController: Populates the system with dummy users using the Faker library.

HealthCheckController: Simple health-check endpoint.

2. Service Layer (service/)
MatchmakingService: Core logic for registration, matchmaking, and filtering exclusions.

3. Model Layer (model/)
userProfile: Represents a user with age, gender, interests, location, and exclusion lists.

4. Utility Layer (util/)
GeoHashUtils: Converts latitude/longitude into geohash (precision 5).

MatchScorer: Scores compatibility using age difference and interest overlap.

5. Store Layer (store/)
InMemoryStore: Singleton managing profile storage and match score maps organized by geohash.

⚙️ Precomputation Design
When a user registers:

Their geohash is computed using GeoHashUtils.

They are added to the appropriate quadrant in InMemoryStore.

Compatibility scores are calculated against all users in the same quadrant using MatchScorer.

These scores are stored in a map for quick retrieval during matchmaking.

This ensures that the matchmaking process remains fast even as the number of users increases.

📁 Project Structure
css
Copy
Edit
src/
├── controller/
│   ├── ProfileController.java
│   ├── SeedController.java
│   └── HealthCheckController.java
├── model/
│   └── userProfile.java
├── service/
│   └── MatchmakingService.java
├── store/
│   └── InMemoryStore.java
├── util/
│   ├── GeoHashUtils.java
│   └── MatchScorer.java
└── MatchmakingApplication.java
▶️ Running the Project
Prerequisites:
Java 17+

Maven

Run the application:
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
By default, the app runs on http://localhost:8080.

📬 API Endpoints
1. Register a Profile
POST /profiles

json
Copy
Edit
{
  "id": "user123",
  "age": 25,
  "gender": "F",
  "lat": 28.6139,
  "lon": 77.2090,
  "interests": ["music", "travel", "art"]
}
2. Get Top 5 Matches
GET /match/{id}

Returns top 5 most compatible profiles for the given user.

3. Seed Dummy Users
GET /seed?count=100

Populates count random user profiles using Faker.

4. Health Check
GET /

Returns "Matchmaking Engine is running!" if the service is alive.

