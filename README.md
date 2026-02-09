# Movie Management Application

A simple, full-stack application to manage movies using Java Spring Boot (Backend) and HTML/CSS/JavaScript (Frontend).

## Features

-   **Add Movie**: Create a new movie with name, description, genre, and rating.
-   **Search Movie**: Find a movie by its auto-generated ID.
-   **In-Memory Storage**: Movies are stored in an `ArrayList` (data resets on restart).
-   **REST API**: proper RESTful endpoints.

## Tech Stack

-   **Backend**: Java 17, Spring Boot
-   **Frontend**: HTML, CSS, Vanilla JavaScript (Fetch API)
-   **Build Tool**: Maven

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.example.movie
│   │       ├── controller  # REST Controllers
│   │       ├── model       # Movie POJO
│   │       └── service     # Business Logic & Storage
│   └── resources
│       └── static          # Frontend files (index.html, style.css, script.js)
```

## How to Run

1.  **Prerequisites**: Ensure you have Java 17 and Maven installed.
2.  **Clone/Download** the project.
3.  **Build** the project:
    ```bash
    mvn clean install
    ```
4.  **Run** the application:
    ```bash
    mvn spring-boot:run
    ```
    *Or run the `MovieManagementApplication` class from your IDE.*

5.  **Access the App**:
    Open your browser and go to: [http://localhost:8080](http://localhost:8080)

## API Endpoints

-   `POST /api/movies` - Add a new movie
-   `GET /api/movies/{id}` - Get movie by ID
-   `GET /` - Health check

## Future Improvements

-   Add data persistence (Database).
-   Add "List All Movies" feature.
-   Add Edit/Delete functionality.
