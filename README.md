# Grant Microservices

This project contains two microservices designed using Spring Boot and Docker. The services can be started together using Docker or run individually without Docker if preferred.

The two services are:

- **grant-service** – exposes basic information about grants
- **application-service** – communicates with grant-service to simulate submitting an application for a grant

---

## Run the Project with Docker (Recommended)

This is the most convenient way to run the services in an isolated environment.

### Requirements

1. **Docker Desktop**
    - Download: https://www.docker.com/products/docker-desktop/
    - Make sure Docker is running before continuing

---

###  Steps to Run with Docker

1. **Clone the Repository**
```bash
git clone https://github.com/stinaosmani/grant-microservices.git
cd grant-microservices
```

2. **Start the Services**
```bash
docker-compose up --build
```

This will:
- Build the applications
- Start both services
- Expose them on:
    - `http://localhost:8081` for grant-service
    - `http://localhost:8080` for application-service

3. **Access Swagger API Docs**
- Grant Service → [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- Application Service → [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

You can test endpoints directly from these pages.

---

##  Run the Project Without Docker

If you prefer running locally through an IDE like IntelliJ or from the terminal:

### Requirements
- Java 17 → [Download here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven (optional, Maven Wrapper is included)
- IntelliJ IDEA or any Java IDE

### Steps

1. Open both `grant-service` and `application-service` in your IDE
2. Right-click on the pom.xml file of each service and select "Add as Maven Project" (if not already imported).
3. Run the main classes:
    - `GrantServiceApplication.java` (localhost:8081)
    - `ApplicationServiceApplication.java` (localhost:8080)

4. Open Swagger UIs:
- [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Use Swagger to test the APIs via browser.

---

## API Docs (Swagger)

| Service              | Swagger URL                            |
|----------------------|-----------------------------------------|
| grant-service        | http://localhost:8081/swagger-ui.html   |
| application-service  | http://localhost:8080/swagger-ui.html   |

---
## Example Usage (Swagger)

Test endpoints directly in Swagger UI:

### Grant Service

1. Open: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
2. Expand `GET /grants/{id}`
3. Try with ID: `1`

**Response:**
```json
{
  "id": "1",
  "title": "Startup Innovation Grant",
  "amount": 5000,
  "category": "Technology"
}
```

### Application Service (which calls Grant Service)

1. Open: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
2. Expand `GET /apply/{grantId}`
3. Try with grant ID: `1`
    - This will fetch data from `grant-service` and return a formatted response.

**Response:**
`Application submitted for: Startup Innovation Grant (Technology), Amount: €5000.0`

---

## Project Structure

The project follows the principles of **Clean Architecture**, emphasizing separation of concerns and independence from frameworks.

Each microservice (`grant-service`, `application-service`) is structured with the following layers:

```
└── src
    └── main
        └── java
            └── com.example.[service]
                ├── app
                │   └── dto          
                │   └── service      
                │   └── error         
                │
                ├── domain
                │   └── model       
                │   └── port         
                │
                ├── infrastructure
                │   └── mapper        
                │   └── client       
                │
                └── controller       
```

## Explanation of Folders

### `app`
Contains application logic (use cases), which coordinates domain logic with infrastructure.

- **`dto`**: Data Transfer Objects used for transferring structured data between layers.
- **`service`**: The actual implementation of business logic (also known as "use cases").
- **`error`**: Global error handling classes.


### `domain`
The heart of the application. Contains pure business rules and interfaces that define what the application does.

- **`model`**: Domain models (entities) that represent core business data.
- **`port`**: Interfaces (also known as "ports") used by the application layer. Implementations in `app.service`.

### `infrastructure`
Contains implementation details for communication with external services or tools.

- **`mapper`**: Classes for mapping between domain models and DTOs, implemented with MapStruct.
- **`client`**: External clients (like Feign clients for inter-service communication).

### `controller`
Web layer for handling HTTP requests and mapping them to service methods. It’s placed outside the layered architecture for simplicity and separation from core logic.

---

## Technologies Used

| Tech                  | Purpose                                     |
|-----------------------|---------------------------------------------|
| Spring Boot           | Web framework for microservice development  |
| Spring Web            | REST APIs                                   |
| Spring Cloud OpenFeign| Service-to-service communication            |
| MapStruct             | DTO ↔ Model mapping                         |
| Docker & Compose      | Containerization                            |
| Swagger / OpenAPI     | API documentation                           |

## Error Handling

To ensure consistent and readable API responses, each service implements a **global exception handler** using Spring’s `@ControllerAdvice`.

- All exceptions are caught and converted into a structured JSON response using a custom `ErrorResponse` class.
- For example, if a grant is not found, instead of returning a plain 404, the service returns:

```json
{
  "timestamp": "2025-04-17T15:58:21.5275978",
  "status": 404,
  "error": "Not Found",
  "message": "Grant with ID 99 not found",
  "path": "/grants/99"
}
```

### Error Classes
| File | Purpose |
|------|---------|
| `app/error/ErrorResponse.java` | Defines the format of the JSON error message |
| `app/error/GlobalExceptionHandler.java` | Centralized handler that intercepts exceptions and returns `ErrorResponse` |