# Hotel Admin Backend - API Documentation

## Overview
This is a REST API for managing hotel rooms with their statuses.

## Base URL
```
http://localhost:8080/api/rooms
```

## Room Status Types
- `VACANT` - Room is vacant and ready for check-in
- `AVAILABLE` - Room is available for booking
- `DIRTY` - Room needs cleaning
- `OUT_OF_ORDER` - Room is under maintenance or repair
- `RESERVED` - Room is reserved for a guest

## Database Configuration
The application uses H2 in-memory database by default for development.

### H2 Console Access
- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:hoteldb`
- Username: `sa`
- Password: (leave empty)

### Switching to MySQL
Uncomment the MySQL configuration in `application.properties` and create a database named `hoteldb`.

---

## API Endpoints

### 1. Create a New Room
**POST** `/api/rooms`

**Request Body:**
```json
{
  "roomNumber": "101",
  "description": "Deluxe room with sea view",
  "status": "AVAILABLE"
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "roomNumber": "101",
  "description": "Deluxe room with sea view",
  "status": "AVAILABLE",
  "createdAt": "2025-11-05T10:30:00",
  "updatedAt": "2025-11-05T10:30:00"
}
```

**cURL Example:**
```bash
curl -X POST http://localhost:8080/api/rooms \
  -H "Content-Type: application/json" \
  -d '{
    "roomNumber": "101",
    "description": "Deluxe room with sea view",
    "status": "AVAILABLE"
  }'
```

---

### 2. Get All Rooms
**GET** `/api/rooms`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "roomNumber": "101",
    "description": "Deluxe room with sea view",
    "status": "AVAILABLE",
    "createdAt": "2025-11-05T10:30:00",
    "updatedAt": "2025-11-05T10:30:00"
  },
  {
    "id": 2,
    "roomNumber": "102",
    "description": "Standard room",
    "status": "RESERVED",
    "createdAt": "2025-11-05T10:35:00",
    "updatedAt": "2025-11-05T10:35:00"
  }
]
```

**cURL Example:**
```bash
curl http://localhost:8080/api/rooms
```

---

### 3. Get Room by ID
**GET** `/api/rooms/{id}`

**Response:** `200 OK`
```json
{
  "id": 1,
  "roomNumber": "101",
  "description": "Deluxe room with sea view",
  "status": "AVAILABLE",
  "createdAt": "2025-11-05T10:30:00",
  "updatedAt": "2025-11-05T10:30:00"
}
```

**cURL Example:**
```bash
curl http://localhost:8080/api/rooms/1
```

---

### 4. Get Room by Room Number
**GET** `/api/rooms/number/{roomNumber}`

**Response:** `200 OK`
```json
{
  "id": 1,
  "roomNumber": "101",
  "description": "Deluxe room with sea view",
  "status": "AVAILABLE",
  "createdAt": "2025-11-05T10:30:00",
  "updatedAt": "2025-11-05T10:30:00"
}
```

**cURL Example:**
```bash
curl http://localhost:8080/api/rooms/number/101
```

---

### 5. Get Rooms by Status
**GET** `/api/rooms/status/{status}`

**Status values:** VACANT, AVAILABLE, DIRTY, OUT_OF_ORDER, RESERVED

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "roomNumber": "101",
    "description": "Deluxe room with sea view",
    "status": "AVAILABLE",
    "createdAt": "2025-11-05T10:30:00",
    "updatedAt": "2025-11-05T10:30:00"
  }
]
```

**cURL Example:**
```bash
curl http://localhost:8080/api/rooms/status/AVAILABLE
```

---

### 6. Update Room
**PUT** `/api/rooms/{id}`

**Request Body:**
```json
{
  "roomNumber": "101",
  "description": "Deluxe room with sea view and balcony",
  "status": "RESERVED"
}
```

**Response:** `200 OK`
```json
{
  "id": 1,
  "roomNumber": "101",
  "description": "Deluxe room with sea view and balcony",
  "status": "RESERVED",
  "createdAt": "2025-11-05T10:30:00",
  "updatedAt": "2025-11-05T11:00:00"
}
```

**cURL Example:**
```bash
curl -X PUT http://localhost:8080/api/rooms/1 \
  -H "Content-Type: application/json" \
  -d '{
    "roomNumber": "101",
    "description": "Deluxe room with sea view and balcony",
    "status": "RESERVED"
  }'
```

---

### 7. Update Room Status Only
**PATCH** `/api/rooms/{id}/status?status={STATUS}`

**Response:** `200 OK`
```json
{
  "id": 1,
  "roomNumber": "101",
  "description": "Deluxe room with sea view",
  "status": "DIRTY",
  "createdAt": "2025-11-05T10:30:00",
  "updatedAt": "2025-11-05T11:15:00"
}
```

**cURL Example:**
```bash
curl -X PATCH http://localhost:8080/api/rooms/1/status?status=DIRTY
```

---

### 8. Delete Room
**DELETE** `/api/rooms/{id}`

**Response:** `204 No Content`

**cURL Example:**
```bash
curl -X DELETE http://localhost:8080/api/rooms/1
```

---

## Error Responses

### 400 Bad Request - Validation Error
```json
{
  "timestamp": "2025-11-05T11:00:00",
  "status": 400,
  "error": "Validation Failed",
  "errors": {
    "roomNumber": "Room number is required",
    "status": "Room status is required"
  }
}
```

### 404 Not Found
```json
{
  "timestamp": "2025-11-05T11:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Room not found with id: 999"
}
```

### 409 Conflict - Duplicate Room Number
```json
{
  "timestamp": "2025-11-05T11:00:00",
  "status": 409,
  "error": "Conflict",
  "message": "Room with number 101 already exists"
}
```

---

## Running the Application

### Start the application:
```bash
./mvnw spring-boot:run
```

### Or run the JAR file:
```bash
java -jar target/HotelAdminBackend-0.0.1-SNAPSHOT.jar
```

The API will be available at: `http://localhost:8080`

---

## Database Schema

### Table: `rooms`

| Column      | Type         | Constraints           |
|-------------|--------------|----------------------|
| id          | BIGINT       | PRIMARY KEY, AUTO_INCREMENT |
| room_number | VARCHAR(20)  | NOT NULL, UNIQUE     |
| description | VARCHAR(500) |                      |
| status      | VARCHAR(20)  | NOT NULL             |
| created_at  | TIMESTAMP    | NOT NULL             |
| updated_at  | TIMESTAMP    | NOT NULL             |

---

## Testing the API with Postman

1. Import the endpoints into Postman
2. Set the base URL to `http://localhost:8080`
3. For POST/PUT requests, set headers: `Content-Type: application/json`
4. Use the example request bodies provided above

---

## Project Structure

```
HotelAdminBackend/
├── src/main/java/com/hotel/HotelAdminBackend/
│   ├── controller/
│   │   └── RoomController.java          # REST API endpoints
│   ├── dto/
│   │   ├── RoomRequest.java             # Request DTO
│   │   └── RoomResponse.java            # Response DTO
│   ├── exception/
│   │   ├── DuplicateResourceException.java
│   │   ├── ResourceNotFoundException.java
│   │   └── GlobalExceptionHandler.java  # Centralized error handling
│   ├── model/
│   │   ├── Room.java                    # Entity class
│   │   └── RoomStatus.java              # Status enum
│   ├── repository/
│   │   └── RoomRepository.java          # Data access layer
│   ├── service/
│   │   └── RoomService.java             # Business logic
│   └── HotelAdminBackendApplication.java # Main application
└── src/main/resources/
    └── application.properties            # Configuration
```
