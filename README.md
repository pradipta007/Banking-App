# Banking App

## Project Overview
This Banking App is a Spring Boot application designed to simulate a basic banking system. It provides functionalities such as account creation, balance checking, deposits, withdrawals.

## Technologies Used
- **Spring Boot** - Framework for building Java-based applications easily.
- **Maven** - Dependency management and project lifecycle management.
- **MySQL** - MySQL database for storage of account data.
- **Spring Data JPA** - Simplifies data access operations.
- **Spring Web** - For creating RESTful web services.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
- JDK 11+
- Maven 3.6+

### Installing
To get the application running locally:

1. **Clone the Repository** <br>
    git clone https://github.com/pradipta007/Banking-App.git <br>
    cd Banking-App

2. **Build Application** <br>
   mvn clean install
   
3. **Run the application** <br>
   java -jar target/banking-app-0.0.1-SNAPSHOT.jar
   
### Usage
After running the application, navigate to http://localhost:8080/ in your web browser to view and manage the banking operations.

### API Endpoints

| Method | Endpoint                       | Description                          |
|--------|------------------------------- |------------------------------------- |
| GET    | `/api/accounts`                | Retrieves all accounts.              |
| GET    | `/api/accounts/{id}`           | Retrieves an account by ID.          |
| POST   | `/api/accounts`                | Creates a new account.               |
| PUT    | `/api/accounts/{id}/deposit`   | Deposit account by ID.               |
| PUT    | `/api/accounts/{id}/withdraw`  | Withdraw amount by ID.               |




