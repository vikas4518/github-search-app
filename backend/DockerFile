# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy all project files to container
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot jar
CMD ["java", "-jar", "target/github.proj-0.0.1-SNAPSHOT.jar"]

