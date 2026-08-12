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
