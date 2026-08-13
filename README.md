


# Patient Microservice

A Java Spring Boot microservice for managing patient records through a REST API, with MongoDB persistence, CRUD operations, automated testing, and Docker support.

## Project Overview

This project demonstrates the development of a backend microservice using **Java and Spring Boot**.

The service provides RESTful operations for managing patient information and uses **MongoDB** as the persistence layer.

The application follows a layered architecture with separate components for:

- REST controllers
- Business/service logic
- Domain models
- Data repositories

## Business Purpose

The microservice provides a backend service for managing patient records.

A patient record contains information such as:

- First Name
- Last Name
- Date of Birth
- Contact Number
- Email Address
- Gender

## Features

- Create patient records
- Retrieve patient records
- Update patient records
- Delete patient records
- REST API endpoints for patient management
- MongoDB persistence
- Service layer for business logic
- Repository layer for database access
- Unit testing using JUnit and Mockito
- Docker containerization
- Docker Compose configuration

## REST API

The service provides REST endpoints for patient management.

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/patients` | Retrieve patients |
| `POST` | `/patients` | Create a patient |
| `PUT` | `/patients/{id}` | Update a patient |
| `DELETE` | `/patients/{id}` | Delete a patient |

## Architecture

The application follows a layered microservice structure:

```text
Client
   |
   v
REST Controller
   |
   v
Service Layer
   |
   v
Repository Layer
   |
   v
MongoDB
````

### Controller Layer

Handles HTTP requests and responses through REST endpoints.

### Service Layer

Contains the business logic for patient management.

### Repository Layer

Handles data persistence and communication with MongoDB.

### Domain Layer

Represents the patient domain model and associated patient information.

## Technology Stack

| Technology     | Purpose                         |
| -------------- | ------------------------------- |
| Java           | Backend programming language    |
| Spring Boot    | Microservice framework          |
| Spring REST    | REST API development            |
| MongoDB        | NoSQL database                  |
| Maven          | Build and dependency management |
| JUnit          | Automated testing               |
| Mockito        | Mocking for unit tests          |
| Docker         | Containerization                |
| Docker Compose | Multi-container configuration   |

## Running the Application

### Using Maven

Navigate to the `PatientService` directory.

#### Linux / macOS

```bash
./mvnw spring-boot:run
```

#### Windows

```bash
mvnw.cmd spring-boot:run
```

The application runs on the default Spring Boot port:

```text
http://localhost:8080
```

## Running Tests

From the `PatientService` directory:

### Linux / macOS

```bash
./mvnw test
```

### Windows

```bash
mvnw.cmd test
```

## Running with Docker Compose

From the `PatientService` directory:

```bash
docker compose up --build
```

This starts the application and its configured containerized services.

## Project Structure

```text
Patient-Microservice/
│
├── PatientService/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/patientmicroservice/
│   │   │   │       ├── controller/
│   │   │   │       ├── service/
│   │   │   │       ├── domain/
│   │   │   │       └── repository/
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   ├── Dockerfile
│   ├── docker-compose.yml
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
│
├── .gitignore
└── README.md
```

## What This Project Demonstrates

This project demonstrates practical experience with:

* REST API design
* CRUD-based business operations
* Microservice architecture
* Layered application design
* NoSQL database integration
* Backend testing
* Dependency management with Maven
* Containerization with Docker
* Docker Compose
* Java Spring Boot development

## Business & Process Analysis Perspective

Although this is a technical backend project, it also demonstrates skills relevant to **Process Analyst and Business Analyst roles**, including:

* Translating a business domain into a software service
* Identifying and modeling business entities
* Defining business operations through REST endpoints
* Translating requirements into system functionality
* Separating business logic from data access responsibilities
* Understanding system components and their responsibilities
* Understanding service-based architectures
* Working with structured business data

## Project Status

This project is an academic/learning microservice implementation demonstrating backend development, REST API design, database integration, testing, and software architecture concepts.

## Future Improvements

Potential future improvements include:

* API documentation using OpenAPI/Swagger
* Enhanced input validation
* Centralized exception handling
* More comprehensive integration testing
* Authentication and authorization
* Improved API response models
* CI/CD automation

