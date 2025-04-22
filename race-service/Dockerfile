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

COPY --from=builder /app/build/libs/*.jar race-service.jar

EXPOSE 8093
ENTRYPOINT ["java", "-jar", "race-service.jar"]