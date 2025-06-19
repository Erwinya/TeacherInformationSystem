# Teacher Information System

A robust, maintainable, and scalable RESTful API for managing teachers, students, classes, and managers, built with Spring Boot and PostgreSQL. The project is designed with SOLID and Clean Code principles for clarity, testability, and extensibility.

## Features
- Teacher, Student, Class, and Manager CRUD operations
- Layered architecture (Controller, Service, Repository, DTO, Mapper)
- Exception handling and validation
- Dockerized for easy deployment
- PostgreSQL integration
- Clean, readable, and maintainable code

## Project Structure
```
├── src/main/java/com/RestfulApi/TeacherInformationSystem/
│   ├── config/        # Configuration classes (Security, Swagger, etc.)
│   ├── controller/    # REST API endpoints
│   ├── dto/           # Data Transfer Objects
│   ├── exception/     # Custom exceptions and global handlers
│   ├── mapper/        # Entity-DTO mappers
│   ├── model/         # JPA entities
│   ├── repository/    # Spring Data JPA repositories
│   ├── response/      # Custom response wrappers
│   ├── service/       # Business logic (interfaces & implementations)
│   └── util/          # Utility classes
├── src/main/resources/
│   ├── application.properties # Main configuration
│   ├── static/                # Static web resources
│   └── templates/             # HTML templates (if needed)
├── docker-compose.yml         # Multi-container orchestration
├── Dockerfile                 # App containerization
├── pom.xml                    # Maven dependencies & build
└── README.md                  # Project documentation
```

## SOLID & Clean Code Principles
- **Single Responsibility:** Each class has one responsibility (e.g., controllers only handle HTTP requests).
- **Open/Closed:** Classes are open for extension, closed for modification (e.g., service interfaces).
- **Liskov Substitution:** Subtypes can replace base types (e.g., service implementations).
- **Interface Segregation:** Fine-grained interfaces (e.g., separate service interfaces).
- **Dependency Inversion:** High-level modules depend on abstractions (e.g., service interfaces injected into controllers).
- **Clean Code:**
  - Meaningful names
  - Small, focused methods
  - No magic numbers/strings
  - Consistent formatting
  - Centralized exception handling

## Getting Started
### Prerequisites
- Java 17+
- Maven
- Docker & Docker Compose

### Build & Run (Local)
```bash
./mvnw clean package -DskipTests
java -jar target/Teacher-Information-System-0.0.1-SNAPSHOT.jar
```

### Build & Run (Docker)
```bash
docker-compose up --build -d
```

### API Usage Example (POST /api/teachers)
```json
{
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "5551234567",
  "department": "Mathematics"
}
```

## Configuration
Edit `src/main/resources/application.properties` for database and server settings.

## Testing
```bash
./mvnw test
```

## Contributing
- Follow SOLID and Clean Code principles
- Write meaningful commit messages
- Add tests for new features

## License
MIT
