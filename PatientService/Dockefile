
# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Add Maven build output JAR to the image
ARG JAR_FILE=target/*.jar

# Copy the built jar from target folder into the container
COPY ${JAR_FILE} app.jar

# Expose port the service listens on (default 8080)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","/app.jar"]
