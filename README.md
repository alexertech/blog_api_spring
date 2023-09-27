# Spring Boot Blog API

Blog API is a RESTful web service developed using Spring Boot, allowing users to interact with a Blog Engine that includes posts. The API does not include authentication and can handle titles and bodies for each post.

This is backend behaves the same as the [Ruby on Rails Blog Api](https://github.com/alexertech/blog_api), just wanted to create the same on a different technology stack.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL
- Maven
- JUnit
- Mockito

## Setup Instructions

### Prerequisites

- Java 8 or higher
- PostgreSQL
- Maven

### Steps

1. **Clone the Repository**
   ```sh
   git clone https://github.com/alexertech/blog_api_spring.git
   cd blog_api_spring
   ```

2. **Set Up the Database**
    - Install PostgreSQL if not already installed.
    - Create a new database named `blog_api_spring`.
    - Update the `application.properties` file with your PostgreSQL username and password.
   ```properties
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   ```

3. **Build and Run the Application**
   ```sh
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

## API Usage

### Get All Posts
```sh
curl -X GET http://localhost:8080/posts
```

### Get Post by ID
```sh
curl -X GET http://localhost:8080/posts/{postId}
```

### Create a New Post
```sh
curl -X POST -H "Content-Type: application/json" -d '{"title": "Post Title", "body": "Post Body"}' http://localhost:8080/posts
```

### Update a Post
```sh
curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated Title", "body": "Updated Body"}' http://localhost:8080/posts/{postId}
```

### Delete a Post
```sh
curl -X DELETE http://localhost:8080/posts/{postId}
```

## Testing

To run the tests, execute the following command in the project directory.
```sh
./mvnw test
```

