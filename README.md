# The-Museum-Cinemaya---Desktop-Backend

## Description
"The Museum Cinemaya" is a desktop application developed by VP CODE LABS. It serves as a comprehensive database management system for film-related information.

## Project Information
- **Name**: The Museum Cinemaya Desktop Backend
- **Description**: This project serves as the backend system for "The Museum Cinemaya" desktop application developed by VP CODE LABS. It provides API endpoints and data management functionalities for handling film-related information.
- **Version**: 1.0.1-SNAPSHOT

## Dependencies
### Spring Boot Dependencies
- **Spring Boot Version**: 3.2.2
- **Java Version**: 17

### Spring Boot Starters
- `spring-boot-starter-data-mongodb`: Provides MongoDB support for Spring Data.
- `spring-boot-starter-web`: Starter for building web applications using Spring MVC.
- `spring-boot-starter-test`: Starter for testing Spring Boot applications.
- `org.projectlombok:lombok`: Library for reducing boilerplate code in Java.

### Other Dependencies
- `com.jayway.jsonpath:json-path`: Library for working with JSON in Java.
- `org.springdoc:springdoc-openapi-starter-webmvc-ui`: Springdoc OpenAPI integration for generating API documentation.

## Configuration
- **Server Port**: 8080
- **Active Profiles**: dev (for development), prod (for production)

### MongoDB Configuration
- **URI**: uri (MongoDB connection URI)
- **Databases**:
  - Development: The-Museum-Cinemaya-Dev
  - Production: The-Museum-Cinemaya-Prod

## Project Structure
- `collection` **Package**: Contains MongoDB document models.
- `config` **Package**: Configuration classes for OpenAPI and CORS.
- `controller` **Package**: Controllers defining API endpoints.
- `dto` **Package**: Data Transfer Object classes.
- `repository` **Package**: Spring Data MongoDB repositories for database interaction.
- `service` **Package**: Service layer for business logic.
- `serviceImpl` **Package**: Implementation classes for service layer.

## API Documentation
- The Museum Cinemaya Desktop Backend APIs offer an immersive array of endpoints designed to seamlessly oversee user engagement.
- API documentation is automatically generated using Springdoc OpenAPI.
- Endpoint documentation is available at [API Documentation](http://localhost:443/swagger-ui/index.html#/) when the application is running.

## Support
 For any issues or inquiries, please contact VP CODE LABS at vp.code.labs@gmail.com