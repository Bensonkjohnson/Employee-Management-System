# Spring Boot Backend Project

This is a Spring Boot project for the backend of Simple Employee Management System

Technologies Covered:

- *Core Java* (OOP, data structures, file handling)
- *Spring Boot *(REST API, database connectivity)- *Spring Boot *(REST API, database connectivity)

 created a *Simple Employee Management System* that allows users to:
- Add a new employee.
- List all employees.
- Update an employee’s details.
- Delete an employee.


Spring Boot Backend:

- REST API Endpoints:
  - `POST /employees`: Adds a new employee to the database.
  - `GET /employees`: Fetches the list of all employees.
  - `PUT /employees/{id}`: Updates the employee data for the given ID.
  - `DELETE /employees/{id}`: Deletes the employee for the given ID.

- Database:
  - username = sa
  - password = pass123
  - Use an in-memory database  H2 .
  - Employee Table:
    - `id`: Auto-generated (Primary Key)
    - `name`: String
    - `age`: Integer
    - `position`: String
    - `salary`: Decimal

- Data Model:
  - An Employee class with fields: `id`, `name`, `age`, `position`, and `salary`.
  - Implement CRUD operations using *JPA/Hibernate*.

Instructions:


1. Backend Application:
   - Create a Spring Boot application with REST API endpoints for employee management.
   - Use *Spring Data JPA* for database interactions.
   - Configure the application to use an in-memory *H2 database* for simplicity.