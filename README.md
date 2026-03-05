# 🚀 Java Task Manager API with DevSecOps Pipeline

A **Spring Boot REST API** for managing tasks, integrated with a **secure DevSecOps CI/CD pipeline** using **Jenkins, SonarQube, Docker, and Trivy**.

This project demonstrates how modern engineering teams **automate builds, enforce code quality, and integrate security scanning directly into the CI/CD workflow**.

---

# 📌 Project Overview

This repository contains a simple **Task Manager REST API** built with **Spring Boot** and integrated into a **DevSecOps pipeline**.

The pipeline automatically performs the following:

✔ Build the application using Maven
✔ Run automated tests
✔ Perform static code analysis with SonarQube
✔ Enforce code quality gates
✔ Build a Docker container image
✔ Scan the container for vulnerabilities using Trivy
✔ Stop deployment if security issues are detected

This reflects real-world **DevSecOps practices where security is integrated into CI/CD pipelines**.

---

# ✨ Features

## 🔧 Application

* REST API for managing tasks
* Create and retrieve tasks
* Built using **Spring Boot**
* Maven-based build system
* Unit test support

## 🔐 DevSecOps Pipeline

* Jenkins CI/CD automation
* SonarQube static code analysis (SAST)
* Docker containerization
* Trivy container vulnerability scanning
* Security gate enforcement

The pipeline **automatically blocks builds with HIGH or CRITICAL vulnerabilities**, ensuring secure delivery.

---

# 🛠 Tech Stack

### Backend

* **Java 17**
* **Spring Boot**
* **Maven**

### DevOps / DevSecOps

* **Jenkins** – CI/CD automation
* **SonarQube** – static code analysis
* **Docker** – containerization
* **Trivy** – container vulnerability scanning

### Tools

* Git
* GitHub
* Postman

---

# 📂 Project Structure

```
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
```

---

# ⚙ DevSecOps Pipeline Workflow

```
Developer Push (GitHub)
        │
        ▼
   Jenkins Pipeline
        │
        ▼
 Maven Build + Tests
        │
        ▼
SonarQube Static Analysis
        │
        ▼
 Quality Gate Check
        │
        ▼
 Docker Image Build
        │
        ▼
 Trivy Security Scan
        │
        ▼
 Deployment Stage
```

If **HIGH or CRITICAL vulnerabilities are detected**, the pipeline **fails automatically**, preventing insecure builds.

---

# 🌐 API Endpoints

Base URL

```
http://localhost:8080/tasks
```

### Get All Tasks

```
GET /tasks
```

Returns a list of all tasks.

---

### Create Task

```
POST /tasks
```

Example request body

```json
{
  "title": "Complete DevSecOps project",
  "description": "Finish implementing CI/CD security pipeline"
}
```

---

# ▶ Running the Project Locally

### 1️⃣ Clone the Repository

```
git clone https://github.com/Raheeemm/java-task-manager-api.git
cd java-task-manager-api
```

### 2️⃣ Build the Project

```
mvn clean install
```

### 3️⃣ Run the Application

```
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

# 🐳 Docker Setup

### Build Docker Image

```
docker build -t task_manager_api .
```

### Run Docker Container

```
docker run -p 8080:8080 task_manager_api
```

---

# 🔍 Security Scanning with Trivy

To manually scan the Docker image:

```
trivy image task_manager_api
```

The Jenkins pipeline automatically runs this scan and **fails if high-severity vulnerabilities are detected**.

---

# 📊 SonarQube Code Analysis

To run analysis manually:

```
mvn sonar:sonar
```

Results can be viewed on the **SonarQube dashboard**.

---

# 🎯 Learning Objectives

This project demonstrates:

* Building REST APIs using **Spring Boot**
* Automating builds with **Jenkins**
* Performing **static code analysis**
* Containerizing applications using **Docker**
* Integrating **security scanning into CI/CD pipelines**
* Implementing **DevSecOps practices**

---

# 🚧 Future Improvements

Possible enhancements:

* Add authentication (JWT)
* Integrate a database (MySQL/PostgreSQL)
* Implement full CRUD operations
* Deploy to Kubernetes
* Add infrastructure automation using Terraform

---

# 👨‍💻 Author

**Abdul Raheem**

GitHub
https://github.com/Raheeemm

---

