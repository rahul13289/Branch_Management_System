# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the pom.xml and src files
COPY . .

# Build the application
RUN mvn clean install

# Run the application
CMD ["java", "-jar", "target/BMS-BackEnd-0.0.1-SNAPSHOT.jar"]
