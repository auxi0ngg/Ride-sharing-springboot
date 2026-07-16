# 🚖 Ride Booking Application

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-6DB33F?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-336791?style=for-the-badge&logo=postgresql)
![PostGIS](https://img.shields.io/badge/PostGIS-3.5-success?style=for-the-badge)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker)
![JWT](https://img.shields.io/badge/JWT-Secured-red?style=for-the-badge)

</p>

---

# 📖 About

Ride Booking Application is a production-inspired backend system built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **PostgreSQL**, **PostGIS**, and **Docker**.

The application simulates a real-world ride-hailing platform similar to Uber or Ola where riders can request rides, drivers can accept and complete rides, wallets are managed securely, payments are processed, and nearby drivers are matched using geospatial queries.

This project focuses on scalable backend architecture, security, spatial databases, and clean layered design.

---

# ✨ Features

## Authentication

- JWT Authentication
- Refresh Token
- BCrypt Password Encryption
- Role Based Authorization

## Rider Features

- Register/Login
- Request Ride
- Cancel Ride
- View Ride History
- View Profile
- Rate Driver

## Driver Features

- Driver Onboarding
- Accept Ride
- Cancel Ride
- Start Ride
- End Ride
- View Ride History
- Rate Rider

## Ride Management

- Ride Request
- Driver Matching
- OTP Verification
- Ride Lifecycle
- Ride Status Tracking

## Wallet & Payment

- Wallet System
- Wallet Transactions
- Cash Payment
- Online Payment Ready Architecture

## Notifications

- Email Notifications
- Spring Mail Integration

## Geospatial Features

- Driver Live Location
- Nearby Driver Search
- Distance Calculation
- PostGIS Geometry Support

---

# 🏗 High Level Architecture

```text
                     Client

                       │

                       ▼

             Spring Boot REST API

                       │

        ┌──────────────┼──────────────┐

        ▼              ▼              ▼

 Authentication     Ride Service   Driver Service

                       │

                       ▼

               Strategy Layer

                       │

                       ▼

              Repository Layer

                       │

                       ▼

         PostgreSQL + PostGIS Database

                       ▲

         ┌─────────────┼────────────┐

         ▼             ▼            ▼

      Spring Mail   Weather API   OSRM API
```

---

# 🔐 Authentication Flow

```text
User Login

    │

    ▼

AuthenticationManager

    │

    ▼

UserDetailsService

    │

    ▼

Password Validation

    │

    ▼

Generate JWT

    │

    ▼

Client Stores JWT

    │

    ▼

Every Request

    │

    ▼

JWT Filter

    │

    ▼

Protected APIs
```

---

# 🚖 Ride Booking Workflow

```text
Ride Requested

      │

      ▼

Create Ride Request

      │

      ▼

Driver Matching Strategy

      │

      ▼

Nearest Driver Found

      │

      ▼

Driver Accepts

      │

      ▼

Ride Created

      │

      ▼

OTP Verification

      │

      ▼

Ride Started

      │

      ▼

Ride Completed

      │

      ▼

Payment Processed

      │

      ▼

Wallet Updated

      │

      ▼

Ratings Submitted
```

---

# 📍 Driver Matching using PostGIS

Unlike traditional applications that store latitude and longitude separately, this application stores driver locations using **PostGIS Geometry(Point,4326)**.

```java
@Column(columnDefinition = "Geometry(Point,4326)")
private Point currentLocation;
```

### Benefits

- Nearby Driver Search
- Radius Queries
- Spatial Indexing
- Distance Calculation
- Better Performance

---

# 🗄 Database Overview

```text
                User
                 │
      ┌──────────┴──────────┐
      ▼                     ▼

   Rider                 Driver

      │                     │

      └──────────┬──────────┘
                 ▼

            RideRequest

                 ▼

               Ride

      ┌──────────┴─────────┐

      ▼                    ▼

   Payment              Rating

      │

      ▼

    Wallet

      │

      ▼

WalletTransaction
```

---

# 🐳 Docker Architecture

```text
                 Docker Compose

      ┌─────────────────────────────┐

      ▼                             ▼

 Spring Boot Container      PostgreSQL + PostGIS

      │                             │

      └──────────────┬──────────────┘

                     ▼

             Docker Internal Network
```

---

# ⚙ Tech Stack

| Category | Technology |
|------------|----------------|
| Language | Java 21 |
| Framework | Spring Boot 3.3 |
| Security | Spring Security |
| Authentication | JWT |
| Database | PostgreSQL |
| Spatial Database | PostGIS |
| ORM | Hibernate |
| Spatial ORM | Hibernate Spatial |
| Documentation | Swagger |
| Build Tool | Maven |
| Mapping | ModelMapper |
| Mail | Spring Mail |
| DevOps | Docker |
| Container Orchestration | Docker Compose |

---

# 📂 Project Structure

```
src
│
├── Advice
├── Config
├── Controller
├── DTO
├── Entity
├── Repository
├── Security
├── Service
├── Strategy
├── Utility
└── RideBookingApplication.java
```

---

# 📖 REST APIs

## Authentication

- POST /auth/signup
- POST /auth/login
- POST /auth/refresh
- POST /auth/onBoardNewDriver

## Rider

- Request Ride
- Cancel Ride
- Get Ride History
- Get Profile
- Rate Driver

## Driver

- Accept Ride
- Cancel Ride
- Start Ride
- End Ride
- Get Ride History
- Get Profile
- Rate Rider

---

# 📸 Swagger Documentation

## Rider APIs

<img width="1522" height="408" alt="image" src="https://github.com/user-attachments/assets/57763044-dfba-452b-bf6a-19e7d0f70d0f" />

## Driver APIs

<img width="1453" height="492" alt="image" src="https://github.com/user-attachments/assets/eb161d35-12fc-41e6-b166-e9f412bc37cf" />

## Authentication APIs

<img width="1480" height="294" alt="image" src="https://github.com/user-attachments/assets/18f2e111-e64b-420b-b509-dbefc57b2075" />


## DTO Schemas

<img width="1459" height="728" alt="image" src="https://github.com/user-attachments/assets/05b23fb0-3592-43b4-b3a8-906827c73f9e" />
<img width="1455" height="466" alt="image" src="https://github.com/user-attachments/assets/55032e52-6e04-431d-a742-8344d48f4957" />


# 🎯 Design Patterns Used

- Repository Pattern
- Strategy Pattern
- DTO Pattern
- Layered Architecture
- Dependency Injection
- Builder Pattern
- Factory Methods (Spring Beans)

---

# 🚀 Running the Project

## Clone Repository

```bash
git clone https://github.com/auxi0ngg/Ride-Booking-Application.git
```

---

## Build

```bash
mvn clean package
```

---

## Docker

```bash
docker compose up --build
```

---

Swagger

```
http://localhost:8700/ride-booking-service/swagger-ui/index.html
```

---

# 📚 Concepts Demonstrated

✅ Spring Boot

✅ Spring Security

✅ JWT Authentication

✅ PostgreSQL

✅ PostGIS

✅ Hibernate Spatial

✅ Docker

✅ Docker Compose

✅ Spatial Queries

✅ Strategy Pattern

✅ Wallet System

✅ Payment Processing

✅ Email Notifications

✅ Swagger

---

# 📈 Future Enhancements

- Redis Caching
- Kafka Integration
- Flyway Database Migration
- Kubernetes Deployment
- Prometheus & Grafana
- CI/CD using GitHub Actions
- AWS Deployment

---

# 👨‍💻 Author

**Arnav Garg**

Associate Analyst @ Deloitte USI

Backend Developer | Java | Spring Boot | PostgreSQL | Docker

---

If you found this project useful, don't forget to ⭐ the repository.
