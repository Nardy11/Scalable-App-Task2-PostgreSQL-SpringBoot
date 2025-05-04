# 📚 Scalable App Task 2: PostgreSQL Integration with Spring Boot

## 📝 Overview
This repository contains the implementation of **Task 2** for the *Architecture of Massively Scalable Applications* course at the **German University in Cairo**, Department of Computer Science, under **Assoc. Prof. Mervat Abu El-Kheir**, Spring 2025.  
The task involves designing and implementing a database schema using **PostgreSQL**, integrating it with a **Spring Boot** application, and developing a robust system to manage entities such as Students, Courses, and Instructors.

---

## 🧩 Project Description

This project includes:

- PostgreSQL database schema with three main entities:
  - **Student**
  - **Instructor**
  - **Course**

### Relationships:
- **Many-to-Many** between Student and Course (Student is the owner).
- **One-to-Many** between Instructor and Course (Course is the owner).

### Application Structure:
- Custom **repositories** and **services** for CRUD operations and business logic.
- RESTful **controllers** exposing all operations via HTTP endpoints.
- **Dockerized** setup for scalable deployment.
- **Database seeding** and **public API testing** available.

---

## ✨ Features

### 🗃️ Database Schema

- **Student**: `id`, `name`, `email`
- **Instructor**: `id`, `name`, `email`
- **Course**: `id`, `name`, `code`, `credit`

### 🛠️ Repositories

- `StudentRepository`: `findStudentsByCourseId`
- `InstructorRepository`: `findInstructorByEmail`
- `CourseRepository`: `enrollStudent`, `unenrollStudent`, `findByInstructorId`

### 💡 Services

- `StudentService`: CRUD + `getStudentsByCourseId`
- `InstructorService`: CRUD + `getInstructorByEmail`
- `CourseService`: CRUD + `enrollStudent`, `unenrollStudent`, `getCoursesByInstructorId`

### 🌐 Controllers

- `StudentController`: Full CRUD + get by course
- `InstructorController`: Get all + get by email
- `CourseController`: CRUD + enroll/unenroll students

### 🐳 Docker Support

- Includes `Dockerfile` and `docker-compose.yml` for containerized deployment.

---

## ⚙️ Setup and Usage

### 1. Configure Environment

Edit `application.properties`:

* Set:

  * `ID=52-8078`
  * `Name=YourName`
* Use port based on your ID (e.g., `8078` for `52-8078`).

### 2. Build and Run

```bash
mvn clean install
docker-compose up
```

Seed the database by visiting:
`http://localhost:8078/seed`

---

## 🌐 API Endpoints

### 👩‍🎓 Students

* `GET /students` — All students
* `GET /students/{id}` — Get by ID
* `POST /students` — Add student
* `PUT /students/{id}` — Update
* `DELETE /students/{id}` — Delete
* `GET /students/course/{courseId}` — Get by course

### 👨‍🏫 Instructors

* `GET /instructors` — All instructors
* `GET /instructors/email/{email}` — Get by email

### 📘 Courses

* `GET /courses` — All courses
* `GET /courses/instructor/{instructorId}` — Get by instructor
* `POST /courses/{courseId}/students/{studentId}` — Enroll student
* `PUT /courses/{courseId}/students/{studentId}` — Unenroll student

---

## 🧪 Testing

Uncomment test code and run:

```bash
mvn test
```

---

## 🧠 Skills Demonstrated

* PostgreSQL schema design and integration
* Spring Boot REST API development
* JPA/Hibernate ORM and custom queries
* Dockerized deployment
* Managing complex entity relationships (Many-to-Many, One-to-Many)
* API testing and Maven-based builds

---

## 📤 Submission

* **Database name**: `YourName_52-8078` (replace with your info)
* **Port**: `8078` (derived from ID `52-8078`)
* **Deadline**: Saturday, **08/03/2025**, 11:59 PM

