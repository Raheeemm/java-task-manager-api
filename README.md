# 🚀 Spring Boot Task Manager API

A simple RESTful Task Manager built using Spring Boot, Maven, and Docker.

This project demonstrates:
- REST API development
- Maven build lifecycle
- Docker containerization
- Basic backend architecture

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Maven
- Docker

---

# 📦 Maven Lifecycle

This project uses Maven for build automation.

Important phases:

| Phase               | Description                      |
|---------------------|----------------------------------|
| `mvn clean`         | Deletes previous build artifacts |
| `mvn compile`       | Compiles source code             |
| `mvn package`       | Packages the app into a JAR      |
| `mvn clean package` | Clean + build                    |

After packaging, the JAR file is generated inside:

```
target/task_manager_api-0.0.1-SNAPSHOT.jar
```

---

# ▶️ Run Locally

Build the project:

```bash
mvn clean package
```

Run the JAR:

```bash
java -jar target/task_manager_api-0.0.1-SNAPSHOT.jar
```

Access API:

```
http://localhost:8080/tasks
```

---

# 🐳 Docker Containerization

## Build Docker Image

```bash
docker build -t task_manager_api .
```

## Run Container

```bash
docker run -p 8080:8080 task_manager_api
```

Access API:

```
http://localhost:8080/tasks
```

---

# 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/tasks` | Get all tasks |
| POST   | `/tasks` | Create new task |
| DELETE | `/tasks/{id}` | Delete task |

### Example Request

```bash
curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{"title":"Learn Docker","completed":false}'
```

---

# 📚 Learning Goals

This project was built to understand:

- Spring Boot fundamentals
- REST API development
- Maven build process
- Docker image creation
- Containerized backend execution
