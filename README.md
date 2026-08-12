# Patient Microservice

A Spring Boot microservice for managing patient records through a REST API, with MongoDB persistence, CRUD operations, testing, and Docker-based deployment.

## Project Overview

This project demonstrates the development of a backend microservice using **Java and Spring Boot**.

The service provides RESTful operations for managing patient information and uses **MongoDB** as the persistence layer.

The project follows a layered backend architecture with separate areas for:

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
- Docker support
- Docker Compose configuration

## REST API

The service exposes REST endpoints for patient management.

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/patients` | Retrieve patients |
| POST | `/patients` | Create a patient |
| PUT | `/patients/{id}` | Update a patient |
| DELETE | `/patients/{id}` | Delete a patient |

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



Controller Layer

Handles HTTP requests and responses through REST endpoints.

Service Layer

Contains the business logic for patient management.

Repository Layer

Handles persistence and communication with MongoDB.

Domain Layer

Represents the patient domain model and its associated data.

Technology Stack
Technology	Purpose
Java	Backend programming language
Spring Boot	Microservice framework
Spring REST	REST API development
MongoDB	NoSQL database
Maven	Build and dependency management
JUnit	Testing
Mockito	Mocking for unit tests
Docker	Containerization
Docker Compose	Multi-container configuration



Running the Application
Using Maven

From the PatientService directory:

./mvnw spring-boot:run

On Windows:

mvnw.cmd spring-boot:run
Running Tests
./mvnw test

On Windows:

mvnw.cmd test
Using Docker Compose

From the PatientService directory:

docker compose up --build

The application is configured to run on the default Spring Boot port:

http://localhost:8080
What This Project Demonstrates

This project demonstrates practical experience with:

REST API design
CRUD-based business operations
Microservice architecture
Layered application design
NoSQL database integration
Backend testing
Containerization
Maven-based Java development
Business & Process Analysis Perspective

Although this is a technical backend project, it also demonstrates skills relevant to process and business analysis roles, including:

Translating a business domain into a software service
Identifying and modeling business entities
Defining CRUD-based business operations
Designing API operations around business requirements
Separating business logic from data access
Understanding system components and their responsibilities
Working with service-based architectures
Project Status

This project is an academic/learning microservice implementation demonstrating backend development and software architecture concepts.
