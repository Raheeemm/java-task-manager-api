Java Task Manager API with DevSecOps Pipeline

A Spring Boot REST API for managing tasks, integrated with a secure CI/CD pipeline using Jenkins, SonarQube, Docker, and Trivy.

This project demonstrates how to build, test, scan, and containerize a Java application while enforcing security checks in the CI/CD pipeline.

Task manager APIs typically provide endpoints to create, read, update, and delete tasks through REST services built with frameworks like Spring Boot.

Project Overview

This project implements a simple Task Manager REST API and integrates it with a DevSecOps pipeline that automatically:

Builds the application using Maven

Runs unit tests

Performs static code analysis with SonarQube

Builds a Docker container

Scans the container for vulnerabilities using Trivy

Enforces a security gate in the CI/CD pipeline

The pipeline fails automatically if HIGH or CRITICAL vulnerabilities are detected, ensuring secure builds.

Features
Application

REST API for task management

Basic CRUD operations for tasks

Built using Spring Boot

Maven-based project

DevSecOps Pipeline

Jenkins CI/CD automation

SonarQube static code analysis (SAST)

Docker containerization

Trivy container vulnerability scanning

Security gate enforcement

Technology Stack

Backend

Java 17

Spring Boot

Maven

DevOps / Security

Jenkins

SonarQube

Docker

Trivy

Tools

Git

GitHub

Postman (for API testing)

Project Structure
java-task-manager-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.egproject.task_manager_api
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       └── TaskManagerApiApplication.java
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md
CI/CD Pipeline Architecture
Developer Push (GitHub)
        ↓
Jenkins Pipeline
        ↓
Maven Build + Tests
        ↓
SonarQube Static Analysis
        ↓
Quality Gate Check
        ↓
Docker Image Build
        ↓
Trivy Container Scan
        ↓
Deploy Stage

Security checks ensure that vulnerable builds do not proceed to deployment.
