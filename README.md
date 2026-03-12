# Patient Microservice

## Project Overview
This project is a **Patient Microservice** built using **Spring Boot** and **MongoDB**.  
It provides RESTful endpoints to manage patient records with full CRUD functionality, allowing clients to add, retrieve, update, and delete patient information.

---

## Domain Model
**Patient (Entity)** with the following properties:
- First Name  
- Last Name  
- Date of Birth  
- Contact Number  
- Email Address  
- Gender  

---

## Features
- **CRUD Operations** for Patients via REST endpoints  
- **Spring Boot Repository** for MongoDB integration  
- **Service Layer** for business logic  
- **RESTful Client** to interact with the microservice  
- **Unit Tests** for controller and service layers using **JUnit** and **Mockito**  
- **Dockerized** service and MongoDB using **Docker Compose**  
- **GitLab CI/CD pipeline** with two stages:
  - `build`: builds the Docker image  
  - `test`: runs unit tests and endpoint tests  

---

## Technology Stack
- **Backend:** Java, Spring Boot  
- **Database:** MongoDB  
- **Testing:** JUnit, Mockito  
- **Containerization:** Docker, Docker Compose  
- **CI/CD:** GitLab CI  

---

## Folder Structure 
PatientMicroservice/
├─ src/
│ ├─ main/
│ │ ├─ java/com/example/patientmicroservice/
│ │ │ ├─ controller/
│ │ │ ├─ service/
│ │ │ ├─ domain/
│ │ │ └─ repository/
│ │ └─ resources/
│ │ ├─ application.properties
│ │ └─ templates/ (if needed)
├─ test/
│ └─ java/... # Unit and integration tests
├─ Dockerfile
├─ docker-compose.yml
├─ .gitlab-ci.yml
├─ pom.xml
└─ README.md

## Usage

Clone the repository:
```bash
git clone https://github.com/wishalfatima/Patient-Microservice.git

Build and run the service using Docker Compose:
docker-compose up --build

Access the REST API (default port 8080):
GET /patients
POST /patients
PUT /patients/{id}
DELETE /patients/{id}

Run unit tests:
mvn test

GitLab CI/CD
Build Stage: Builds the Docker image for the service
Test Stage: Runs unit tests and endpoint tests
