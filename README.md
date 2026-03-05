🚀 Java Task Manager API – DevSecOps CI/CD Pipeline


A Spring Boot REST API integrated with a DevSecOps CI/CD pipeline that automatically builds, analyzes, containerizes, and scans the application for security vulnerabilities.

This project demonstrates how modern teams integrate security directly into the CI/CD pipeline using industry-standard tools.

📌 Project Overview

This repository contains a Task Manager REST API built using Spring Boot and secured through an automated DevSecOps pipeline.

The pipeline ensures that every code change goes through:

✔ Build automation
✔ Static code analysis
✔ Security scanning
✔ Containerization
✔ Security gate enforcement

This helps maintain secure and reliable software delivery.

⚙️ Tech Stack
Backend

Java 17

Spring Boot

Maven

DevOps & Security

Jenkins – CI/CD automation

SonarQube – Static code analysis (SAST)

Docker – Containerization

Trivy – Container vulnerability scanning

Tools

Git

GitHub

Postman

📂 Project Structure
java-task-manager-api
│
├── src
│   ├── main
│   │   ├── java/com/egproject/task_manager_api
│   │   │   ├── TaskController.java
│   │   │   ├── Task.java
│   │   │   └── TaskManagerApiApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md


🔄 DevSecOps Pipeline

The CI/CD pipeline automates the entire process from code commit to deployment.

Developer Push (GitHub)
        ↓
Jenkins Pipeline
        ↓
Maven Build + Unit Tests
        ↓
SonarQube Code Analysis
        ↓
Quality Gate Check
        ↓
Docker Image Build
        ↓
Trivy Vulnerability Scan
        ↓
Deploy Stage
Security Gate

The pipeline automatically fails if:

HIGH vulnerabilities are detected

CRITICAL vulnerabilities are detected

SonarQube quality gate fails

This ensures only secure builds are deployed.


🌐 API Endpoints

Base URL

http://localhost:8080/tasks
Get All Tasks
GET /tasks

Returns all tasks.

Create Task
POST /tasks

Example Request Body

{
  "title": "Complete DevSecOps Project",
  "description": "Implement CI/CD security pipeline"
}


▶️ Running the Project Locally
Clone the Repository
git clone https://github.com/Raheeemm/java-task-manager-api.git
cd java-task-manager-api
Build the Project
mvn clean install
Run the Application
mvn spring-boot:run

Application runs at:
http://localhost:8080

🐳 Docker Setup
Build Docker Image
docker build -t task_manager_api .
Run Container
docker run -p 8080:8080 task_manager_api

🔐 Security Scanning with Trivy

Scan the Docker image manually:

trivy image task_manager_api

The CI/CD pipeline performs this scan automatically and blocks insecure builds.

📊 SonarQube Analysis

Run analysis manually:

mvn sonar:sonar

Results can be viewed on the SonarQube dashboard.

🎯 Learning Outcomes

This project demonstrates practical experience with:

REST API development using Spring Boot

CI/CD automation using Jenkins

Static application security testing (SAST)

Containerization with Docker

Container vulnerability scanning with Trivy

Secure DevSecOps pipeline design
