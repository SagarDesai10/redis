# Use a base image with Maven to build the app
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Use a smaller base image with JDK only
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
