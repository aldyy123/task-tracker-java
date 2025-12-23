# Task Tracker API

Simple **Task Tracker REST API** built with **Java Spring Boot**.  
This project demonstrates clean backend fundamentals such as CRUD operations, validation, global error handling, pagination, and consistent API responses.

---

## ✨ Features

- CRUD Task (Create, Read, Update, Delete)
- Request & Response DTO
- Validation with clear error messages
- Global Exception Handling
- Consistent API Response format
- Pagination, Sorting, and Filtering
- In-memory database (H2)

---

## 🛠 Tech Stack

- Java 25
- Spring Boot
- Spring Data JPA
- H2 Database
- Gradle

---

## 📦 API Endpoints

Base URL: `http://localhost:8080/api/tasks`

| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/tasks` | Create task |
| GET | `/api/tasks` | Get all tasks (pagination & filter) |
| GET | `/api/tasks/{id}` | Get task by id |
| PUT | `/api/tasks/{id}` | Update task |
| DELETE | `/api/tasks/{id}` | Delete task |

---

## 🔍 Pagination & Filter Example

GET /api/tasks?page=0&size=5&sort=createdAt,desc
GET /api/tasks?status=TODO&page=0&size=10

---

## ▶️ How to Run

```bash
./gradlew bootRun
```