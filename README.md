# TodoApp

A simple Todo application built using **Spring Boot** (for backend), **MySQL** (for database), and **React** with **Vite** (for frontend).

## Table of Contents
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setting Up Backend (Spring Boot)](#setting-up-backend-spring-boot)
- [Setting Up Frontend (React + Vite)](#setting-up-frontend-react--vite)
- [Running the Application](#running-the-application)

## Technologies Used

### Backend
- Java 17
- Spring Boot
- MySQL
- Maven

### Frontend
- React 18
- Vite
- Axios
- TailwindCSS

## Features
- Add new tasks
- Mark tasks as completed
- Delete tasks
- Undo and redo operations

## Prerequisites
Before running the project, make sure you have the following installed on your machine:
- **Java 17** or above
- **Maven** 
- **MySQL** 
- **Node.js** (with npm)

## Setting Up Backend (Spring Boot)

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/todoapp.git
cd todoapp
```

### Step 2: Configure MySQL Database

Create a MySQL database named `todo`. You can use the following SQL command:

```sql
CREATE DATABASE todo;
```

### Step 3: Configure Application Properties

Update the `src/main/resources/application.properties` file with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Step 4: Build and Run the Spring Boot Application

Make sure you are in the root directory of the backend (`todoapp`).

```bash
mvn clean install
mvn spring-boot:run
```

The backend will be running on `http://localhost:8080`.

## Setting Up Frontend (React + Vite)

### Step 1: Navigate to the Frontend Directory

```bash
cd frontend
```

### Step 2: Install Dependencies

Install the dependencies using npm:

```bash
npm install
```

### Step 3: Run the React App

Start the development server:

```bash
npm run dev
```

The React app will be running on `http://localhost:5173`.

## Running the Application

### Accessing the Application

- Backend API: `http://localhost:8080/tasks`
- Frontend: `http://localhost:5173`

### API Endpoints

The backend exposes the following REST API endpoints:

- `GET /tasks`: Fetch all tasks
- `POST /tasks/add`: Add a new task
- `POST /tasks/complete/{id}`: Mark a task as completed
- `POST /tasks/delete/{id}`: Delete a task
- `POST /tasks/undo`: Undo the last operation
- `POST /tasks/redo`: Redo the last operation

### CORS Configuration

CORS is enabled for the frontend to communicate with the backend. It allows requests from `http://localhost:5173`.

### How to Deploy

For production deployment, you can:
1. Package the Spring Boot backend as a JAR and deploy it to a server (e.g., Azure App Service).
2. Build the React frontend using `npm run build` and serve the static files using Azure Storage or any static site hosting service.
```

### Key Points:
- The backend is a Spring Boot application running on port `8080`.
- The frontend is a React app (Vite) running on port `5173`.
- The MySQL database should be set up before running the backend.
- CORS has been configured to allow communication between the frontend and backend.
