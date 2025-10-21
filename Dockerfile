# Build stage
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
COPY wallet ./wallet

# Ensure wallet files have correct permissions
RUN chmod 600 wallet/*

EXPOSE 8080
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]