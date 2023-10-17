# Etapa de construcción
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17-slim

EXPOSE 8080

COPY --from=build /app/target/v1-0.0.1-SNAPSHOT.jar /app/v1-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/v1-0.0.1-SNAPSHOT.jar"]
