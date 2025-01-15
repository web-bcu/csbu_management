FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM gcr.io/distroless/java21-debian12
WORKDIR /app
COPY --from=builder /app/target/mvc_management-0.0.1-SNAPSHOT.jar .
EXPOSE 8070

ENTRYPOINT [ "java", "-jar", "/app/mvc_management-0.0.1-SNAPSHOT.jar" ]