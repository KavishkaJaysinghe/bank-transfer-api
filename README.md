# Account Transfer API

This is a RESTful API for transferring money between accounts using Java Spring Boot (Java 17) with an H2 in-memory database.

## Technologies Used
- Java 17
- Spring Boot
- H2 In-Memory Database
- JUnit for Testing
- Postman for API Testing

## API Endpoints
### Transfer Money
**Endpoint:** `POST /api/transfer`

**Request Body:**
```json
{
  "sourceAccountNumber": "67890",
  "destinationAccountNumber": "12345",
  "amount": 200.00
}
```

**Response Examples:**
1. **Success Response:**
```json
{
  "message": "Transfer successful",
  "transactionId": "abc123",
  "sourceAccount": "67890",
  "destinationAccount": "12345",
  "transferredAmount": 200.00
}
```

2. **Account Not Found:**
```json
{
  "error": "Account not found"
}
```

3. **Insufficient Balance:**
```json
{
  "error": "Insufficient balance"
}
```

## JUnit Test Coverage
- Unit tests for successful transfer
- Unit tests for account not found scenario
- Unit tests for insufficient balance scenario

## Postman Screenshots
<p align="center">
    <img src="https://github.com/KavishkaJaysinghe/bank-transfer-api/blob/main/img/Screenshot%202025-02-28%20143733.png" width="30%">
    <img src="https://github.com/KavishkaJaysinghe/bank-transfer-api/blob/main/img/Screenshot%202025-02-28%20143934.png" width="30%">
    <img src="https://github.com/KavishkaJaysinghe/bank-transfer-api/blob/main/img/Screenshot%202025-02-28%20144032.png" width="30%">
</p>

## Setup Instructions
1. Clone the repository.
2. Run the application using:
   ```sh
   mvn spring-boot:run
   ```
3. Use Postman to test the transfer API.

## Notes
- The H2 database is reset every time the application restarts.
- Sample data is preloaded in the database for testing.

## Contact
For any issues, contact the developer at [your email or GitHub].

