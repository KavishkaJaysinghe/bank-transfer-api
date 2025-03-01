# Account Transfer API

This is a RESTful API for transferring money between accounts using Java Spring Boot (Java 17).

## Technologies Used
- Java 17
- Spring Boot
- JUnit for Testing
- Postman for API Testing

## API Endpoints
### Transfer Money
**Endpoint:** `POST /api/transfer`

## 🏦 Mock Accounts

The application initializes with the following mock accounts:

```java
public void addMockAccounts() {
    accountDatabase.put("12345", new Account("12345", 10000.00));
    accountDatabase.put("67890", new Account("67890", 15000.00));
}
```
**Request Body:**
```json
{
  "sourceAccountNumber": "67890",
  "destinationAccountNumber": "12345",
  "amount": "XXX.XX"
}
```

**Response Examples:**
1. **Success Response:**
```json
{
  "message": "Transfer successful",
  "sourceAccountNumber": "XXXXXX",
  "sourceBalance": "XXXXXX",
  "destinationAccountNumber": "XXXXXX",
  "destinationBalance": "XXXXX"
}
```

2. **Account Not Found:**
```json
{
  "error": "Source account not found: XXXX"
}
```
**OR**
```json
{
  "error": "destinationAccount account not found: XXXX"
}
```

3. **Insufficient Balance:**
```json
{
  "error": "Insufficient funds"
}
```

## JUnit Test Coverage
- Unit tests for successful transfer
- Unit tests for account not found scenario
- Unit tests for insufficient balance scenario
<p align="center">
    <img src="https://github.com/KavishkaJaysinghe/bank-transfer-api/blob/main/img/Screenshot%202025-02-28%20155025.png" width="60%">
</p>

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
   ## Prerequisites  
This project requires **Java 17** to run. If you have a newer Java version (such as Java 23), you may encounter compatibility issues with the Maven compiler plugin.  

### **Check Your Java Version, Before running the application.**  

3. Use Postman to test the transfer API.
```http
http://localhost:12345/api/transfers
```
## OR  
Clone the repository in IntelliJ IDEA and run the application. 
##
<p align="center">
    <img src="https://github.com/KavishkaJaysinghe/bank-transfer-api/blob/main/img/Screenshot%202025-02-28%20165909.png" width="60%">
</p>

### Notes
- The database is reset every time the application restarts.
- Sample data is preloaded in the database for testing.

## Contact
contact the developer at,
📧 Email: [kavishkajaye@gmail.com](mailto:kavishkajaye@gmail.com)  
💼 LinkedIn: [Kavishka Jayasinghe](https://www.linkedin.com/in/kavishka-jayasinghe)

