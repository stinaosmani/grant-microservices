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

Example:
- `GET /apply/1` → application-service will call grant-service and return a composed result

---

##  Run the Project Without Docker

If you prefer running locally through an IDE like IntelliJ or from the terminal:

### Requirements
- Java 17 → [Download here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven (optional, Maven Wrapper is included)
- IntelliJ IDEA or any Java IDE

### Steps

1. Open both `grant-service` and `application-service` in your IDE
2. Run the main classes:
    - `GrantServiceApplication.java` (localhost:8081)
    - `ApplicationServiceApplication.java` (localhost:8080)

3. Open Swagger UIs:
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
## Example Usage

### 1. Test Grant Service directly

**Request:**
`GET http://localhost:8081/grants/1`

**Response:**
```json
{
  "id": "1",
  "title": "Startup Innovation Grant",
  "amount": 5000,
  "category": "Technology"
}
```
### 2. Test Application Service (which calls Grant Service)

**Request:**
`GET http://localhost:8080/apply/1`

**Response:**
`Application submitted for: Startup Innovation Grant (Technology), Amount: €5000.0`





