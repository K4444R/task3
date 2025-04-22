FROM gradle:7.6-jdk8 AS builder
WORKDIR /app

COPY . .
RUN chmod +x gradlew

RUN ./gradlew --version

RUN ./gradlew clean bootJar -x test --no-daemon

RUN ls -la build/libs/

FROM openjdk:8-jdk-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar eureka-server.jar

RUN ls -la eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]