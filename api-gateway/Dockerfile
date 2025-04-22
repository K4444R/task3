FROM gradle:7.6-jdk8 AS builder
WORKDIR /app

COPY gradle/ gradle/
COPY gradlew gradlew.bat ./
RUN chmod +x gradlew

COPY settings.gradle* build.gradle* ./
RUN ./gradlew --version

COPY src/ src/
RUN ./gradlew clean build -x test --no-daemon
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]