# DevSecOps CI/CD Pipeline | Java Task Manager API

**A security-focused CI/CD pipeline integrating automated builds, code quality analysis, containerization, and vulnerability scanning into the software delivery workflow.**

This project demonstrates the implementation of **DevSecOps practices using Jenkins, SonarQube, Docker, and Trivy**, with a Java Spring Boot REST API serving as the application being built, analyzed, containerized, and security-scanned.

The primary objective is to integrate security checks into the CI/CD process rather than treating security as a separate activity after development.

## 🔐 Project Overview

Traditional CI/CD pipelines focus primarily on automating software builds and deployments. A DevSecOps pipeline extends this process by incorporating security and code quality checks throughout the delivery lifecycle.

In this project, a GitHub push triggers Jenkins through a webhook. Jenkins orchestrates the pipeline, which builds and tests the application using Maven, analyzes source code with SonarQube, enforces the configured Quality Gate, builds a Docker image, and scans the image for vulnerabilities using Trivy.

The pipeline is configured to stop when the required quality or security checks fail, preventing the workflow from proceeding to deployment with identified blocking issues.

### Key Objectives

* Automate application builds and tests using Jenkins and Maven.
* Integrate static code analysis through SonarQube.
* Enforce code quality requirements using Quality Gates.
* Containerize the application using Docker.
* Scan container images for known vulnerabilities using Trivy.
* Introduce security checks as automated gates in the CI/CD workflow.

## 🏗️ DevSecOps Pipeline Architecture

```text
       Developer Push
             |
             v
      GitHub Repository
             |
             v
       GitHub Webhook
             |
             v
      Jenkins Pipeline
             |
             v
      Maven Build & Tests
             |
             v
    SonarQube Code Analysis
             |
             v
       Quality Gate
             |
             v
      Docker Image Build
             |
             v
       Trivy Image Scan
             |
             v
   Security Policy Evaluation
             |
       +-----+-----+
       |           |
       v           v
   Checks Pass   Checks Fail
       |           |
       v           v
 Continue to    Stop Pipeline
 Deployment     Progression
```

*The diagram represents the intended pipeline flow. Deployment proceeds only when the configured quality and security conditions are satisfied.*

## 🔄 Pipeline Stages

### 1. Source Control and Automation

**Tools: Git, GitHub, Jenkins**

* Store and manage the application source code in GitHub.
* Trigger the Jenkins pipeline through a GitHub webhook when changes are pushed.
* Automate subsequent build, analysis, containerization, and security-check stages.

### 2. Build and Test

**Tool: Maven**

* Compile the Java Spring Boot application.
* Execute the configured automated tests.
* Verify the build before proceeding to subsequent stages.

### 3. Static Code Analysis

**Tool: SonarQube**

* Analyze source code for maintainability and code quality issues.
* Integrate analysis results into the CI/CD workflow.
* Use a Quality Gate to determine whether the pipeline can continue.

### 4. Quality Gate Enforcement

**Tool: SonarQube**

* Evaluate the analysis against the configured Quality Gate.
* Stop pipeline progression when the gate fails.
* Prevent code that does not meet the configured quality requirements from advancing to the next stage.

### 5. Containerization

**Tool: Docker**

* Build a container image of the Java application.
* Package the application and its runtime requirements into a Docker image.
* Prepare the image for vulnerability scanning and the subsequent delivery workflow.

### 6. Container Vulnerability Scanning

**Tool: Trivy**

* Scan the Docker image for known vulnerabilities.
* Evaluate findings against the pipeline's configured severity threshold.
* Stop pipeline progression when blocking HIGH or CRITICAL vulnerabilities are detected.

This stage demonstrates a key DevSecOps principle: **security scanning is part of the automated delivery pipeline, and identified blocking vulnerabilities can prevent deployment.**

### 7. Deployment Control

The deployment stage follows the quality and security checks.

If the required checks pass, the pipeline can proceed to deployment. If a blocking check fails, the pipeline stops instead of advancing.

The actual outcome depends on the results of the configured pipeline stages.

## 🛠️ Technology Stack

| Technology  | Purpose                                        |
| ----------- | ---------------------------------------------- |
| Java 17     | Application development                        |
| Spring Boot | REST API framework                             |
| Maven       | Application build and testing                  |
| Git         | Source control                                 |
| GitHub      | Source code repository and webhook integration |
| Jenkins     | CI/CD pipeline orchestration                   |
| SonarQube   | Static code analysis and Quality Gates         |
| Docker      | Application containerization                   |
| Trivy       | Container image vulnerability scanning         |
| Postman     | API testing                                    |

## 🧩 Application Under Test

The Java Task Manager API serves as the application being processed by the DevSecOps pipeline.

It is a Spring Boot REST API that provides basic task management functionality.

### Current API Endpoints

| Method | Endpoint | Purpose            |
| ------ | -------- | ------------------ |
| GET    | `/tasks` | Retrieve all tasks |
| POST   | `/tasks` | Create a task      |

### Example Request

**Endpoint:** `POST /tasks`

```json
{
  "title": "Complete DevSecOps project",
  "description": "Validate the automated CI/CD security pipeline"
}
```

**Local base URL:** `http://localhost:8080`

The API is intentionally kept lightweight so the main focus remains on the DevSecOps workflow rather than extensive application features.

## 📂 Project Structure

```text
java-task-manager-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/egproject/task_manager_api/
│   │   │       ├── TaskController.java
│   │   │       ├── Task.java
│   │   │       └── TaskManagerApiApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .mvn/
│   └── wrapper/
├── Dockerfile
├── Jenkinsfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🚀 Running the Application Locally

These instructions run the application independently of the Jenkins pipeline.

### Prerequisites

* Java 17
* Maven
* Git
* Docker (for containerization and image scanning)

### 1. Clone the Repository

```bash
git clone https://github.com/Raheeemm/java-task-manager-api.git
cd java-task-manager-api
```

### 2. Build the Application

Using Maven:

```bash
mvn clean install
```

Alternatively, use the Maven Wrapper included in the repository:

**Windows:**

```powershell
.\mvnw.cmd clean install
```

**Linux/macOS:**

```bash
./mvnw clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Alternatively, use the Maven Wrapper:

**Windows:**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

The application is expected to be available at:

`http://localhost:8080`

## 🐳 Docker Image Build

Build the application image from the repository root:

```bash
docker build -t task_manager_api .
```

Run the container:

```bash
docker run -p 8080:8080 task_manager_api
```

The application can then be accessed at:

`http://localhost:8080`

## 🔍 Manual Security Scanning with Trivy

The Docker image can also be scanned manually, independently of Jenkins.

```bash
trivy image task_manager_api
```

Review the findings for vulnerable dependencies and operating-system packages.

The Jenkins pipeline integrates Trivy into the automated workflow and applies the configured policy to determine whether the pipeline can continue.

## 📊 SonarQube Analysis

SonarQube is integrated into the pipeline to analyze source code and evaluate code quality.

A manual Maven analysis can be initiated with:

```bash
mvn sonar:sonar
```

This command requires a correctly configured SonarQube server and the necessary Maven analysis settings and credentials.

Analysis results can be reviewed in the SonarQube dashboard.

## 🛡️ DevSecOps Practices Demonstrated

| Practice                                   | Implementation                                                           |
| ------------------------------------------ | ------------------------------------------------------------------------ |
| Continuous Integration                     | GitHub webhook-triggered Jenkins pipeline                                |
| Automated Build                            | Maven                                                                    |
| Automated Testing                          | Maven-configured tests                                                   |
| Static Application Security Testing (SAST) | SonarQube source analysis                                                |
| Quality Enforcement                        | SonarQube Quality Gate                                                   |
| Containerization                           | Docker                                                                   |
| Container Security                         | Trivy vulnerability scanning                                             |
| Security Gate Enforcement                  | Stop pipeline progression when configured blocking findings are detected |

## 📚 Key Learnings

This project provided practical exposure to:

* Designing and integrating a CI/CD workflow using Jenkins.
* Connecting GitHub webhooks to automated pipeline execution.
* Building and testing a Java application with Maven.
* Integrating SonarQube analysis and Quality Gate enforcement.
* Containerizing applications with Docker.
* Scanning container images for known security vulnerabilities using Trivy.
* Using automated quality and security checks to control pipeline progression.
* Understanding how DevSecOps integrates security into the software delivery lifecycle.

## 👨‍💻 Author

**Abdul Raheem**

GitHub: [Raheeemm](https://github.com/Raheeemm)

---

**Project Focus:** DevSecOps | CI/CD Automation | Application Security | Container Security

GitHub
https://github.com/Raheeemm

---

