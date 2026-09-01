# Client Lead Management System

A beginner-friendly full-stack project for managing client leads.

## Features
- Add, edit and delete leads
- Search by client/company
- Track lead status: New, Contacted, Qualified, Proposal, Won, Lost
- Track priority and estimated value
- Dashboard statistics and pipeline value
- REST API using Spring Boot
- Persistent H2 database (file based)
- React + Vite frontend

## Requirements
- Java 17+
- Maven 3.9+
- Node.js 18+

## Run backend
```bash
cd backend
mvn spring-boot:run
```
API: http://localhost:8080/api/leads
H2 console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:file:./data/leadmanagement
User: sa
Password: (empty)

## Run frontend
Open another terminal:
```bash
cd frontend
npm install
npm run dev
```
Then open the URL shown by Vite (normally http://localhost:5173).

## REST endpoints
- GET /api/leads
- GET /api/leads?search=acme
- GET /api/leads?status=QUALIFIED
- GET /api/leads/{id}
- POST /api/leads
- PUT /api/leads/{id}
- DELETE /api/leads/{id}
- GET /api/leads/stats

## Sample POST JSON
```json
{
  "clientName":"Rahul Sharma",
  "email":"rahul@example.com",
  "phone":"9876543210",
  "company":"ABC Technologies",
  "source":"LinkedIn",
  "status":"NEW",
  "priority":"HIGH",
  "value":75000,
  "notes":"Interested in software services"
}
```
