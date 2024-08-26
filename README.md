# ToDoList Application

## Overview
The **ToDoList Application** is a simple web-based task management system built using Spring Boot, Thymeleaf, and a PostgreSQL database. 
The application allows users to manage their to-do list by adding, categorizing, and viewing tasks based on their importance (simple, important, and urgent).

## Features
- **Add New Tasks**: Users can add new tasks by selecting the task type (Simple, Important, or Urgent) and providing a description.
- **View Tasks**: Tasks are categorized and displayed under three sections: Simple Tasks, Important Tasks, and Urgent Tasks.
- **Task Persistence**: All tasks are stored in a PostgreSQL database using JPA for data persistence.

## Technologies Used
- **Backend**: Spring Boot (MVC, JPA, Dependency Injection)
- **Frontend**: Thymeleaf, HTML, CSS
- **Database**: PostgreSQL
- **Build Tool**: Maven

## Project Structure
The project is structured as follows:
```plaintext
src/
├── main/
│   ├── java/
│   │   └── org/ojl3g/
│   │       ├── controller/
│   │       │   └── CaseController.java    # Controller for handling HTTP requests
│   │       ├── entity/
│   │       │   ├── Case.java              # Abstract base class for tasks
│   │       │   ├── ImportantMatter.java   # Entity for important tasks
│   │       │   ├── SimpleMatter.java      # Entity for simple tasks
│   │       │   ├── UrgentMatter.java      # Entity for urgent tasks
│   │       │   └── Audit.java             # Entity for task audit logs
│   │       ├── repository/
│   │       │   ├── CaseRepository.java    # JPA repository interface for task entities
│   │       │   └── AuditRepository.java   # JPA repository interface for audit entities
│   │       └── service/
│   │           └── CaseService.java       # Service layer for business logic
│   ├── resources/
│   │   ├── application.properties         # Application configuration file
│   │   ├── templates/
│   │   │   ├── index.html                 # Thymeleaf template for the main page
│   │   │   ├── add_case.html              # Thymeleaf template for adding a new task
│   │   │   └── task_history.html          # Thymeleaf template for viewing task history
│   │   └── static/
│   │       └── css/
│   │           └── styles.css             # CSS styles for the application
└── test/
    └── java/                              # Unit and integration tests (not implemented in this example)


