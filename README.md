# DevelopmentBooks Kata - 2025 CCE-E

**Objective**
Calculate the total price of a basket of development books with discounts for unique sets using Java + Spring Boot (TDD).

**Tech Stack**
- Java 17
- Spring Boot
- JUnit 5
- Maven

**Run Instructions**
```bash
mvn clean install
mvn spring-boot:run
```

**Test**
```bash
mvn test
```

**Assumptions**
- Each book costs €50
- Discounts apply to sets of unique books only
- Algorithm uses greedy grouping (not optimal by dynamic programming)

**Structure**
- `Book` enum - list of books
- `PriceCalculatorService` - logic
- `PriceCalculatorController` - REST API (`POST /api/books/calculate-price`)
- `BookBasketRequest`, `BookPriceResponse` - DTOs
- `PriceCalculatorServiceTest` - test-driven validations

**API Usage
POST `/api/books/calculate-price`
Request Body:**
```json
{
  "books": ["CLEAN_CODE", "CLEAN_CODE", "CLEAN_CODER", "TDD_BY_EXAMPLE"]
}
```
**Response:**
```json
{
  "totalPrice": 190.00
}
```
