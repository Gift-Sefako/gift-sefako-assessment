## Description:
This SpringBoot application consists of two controllers: `NumbersTestController` and `AddressTestController`. These controllers handle endpoints related to numerical operations and address management respectively to allow for easier testing of functionality as required by the assessment.

## Prerequisites:
- JDK 17 installed on your machine
- Apache Maven installed on your machine
- Git installed on your machine

## Running the Application:

1. Build the application using Maven:
    ```bash
    mvn clean install
    ```
2. Run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```
3. Once the application has started successfully, you can access the Swagger UI at:
   [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## Usage:
- `NumbersTestController`: This controller provides endpoints for testing numerical operations.
- `AddressTestController`: This controller manages endpoints related to address operations.

## Additional Notes:
- Make sure no other application is running on port 8080 to avoid conflicts.
- Addresses are stored in src/main/resources/addresses/addresses.json

## Contact:
For any issues or queries related to the application, please contact [Gift Sefako] at [gift.s@sefakogroupservices.com].

