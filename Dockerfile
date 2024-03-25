FROM docker.io/amazoncorretto:17-alpine3.18-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/app.jar /app/app.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]