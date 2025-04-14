# Use official OpenJDK image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built jar
COPY target/grant-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
