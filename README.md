# Notes-App

##  Description
A server program that supports simple CRUD operations and authentication

---

## Features

Authenticated users can:
- Get a list of notes sorted by date in reverse order 
- Create a new note
- Like a note
- Remove like from note

Non-authenticated users can:

- Register (add a new user to DB)
- Create a new note

---

## Technologies
- Java 17
- Maven 4
- MongoDb
- Spring Boot 2.6.8
- Spring Security 5.2.2

---
## Implemenation details
- **Models** represent collections in the database
- **DTOs** represent communication with the user
- **DTO mappers** for converting DTOs to entities and vice versa
- All interaction with the database occurs at the **DAO** level
- **Config package** is responsible for security settings and beans creation
- All operations are available at the **Service**
- All interaction client-server occurs through **Controllers**
- **BCryptPasswordEncoder** is used for password encryption
- A custom implementation of **UserDetailService** is used for database authorization 

---

## Quickstart
1. Fork this repository
2. Clone the project to your computer
3. Install MongoDb to your computer, or you can use Atlas cloud service
4. Create new schema in database. You can run next commands in your terminal:
5. Add you DB properties to **application.properties**. Depending on the type of database (local or cloud), add the necessary settings to the file, such as the database name, username, password, or URL to the Atlas service. Comment out the option that is not used.
6. Run project
7. You can add test users by using InjectController and following the [link](http://localhost:8080/inject)
8. For testing, you can use **Postman** or another utility at your discretion
    
   *Use following headers:*

    *key*: **Content-Type**, *value*: **application/json** for sending data in JSON

    *key*: **Authorization**, *value*: **Basic** ***username:password*** ***encoded in Base64*** for authorization
9. You can get all information about endpoints using **[Swagger web interface](localhost:8080/swagger-ui/)**

---

## Author

[Vitalii Shkliarskyi](https://github.com/VitaliiShkliarskyi)