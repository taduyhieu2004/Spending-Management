FROM maven:3.8.3 AS build-dependency
WORKDIR /opt/app-dev

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app-dev
COPY --from=build-dependency opt/app-dev/target/*.jar .


ENTRYPOINT java -jar /opt/app-dev/*.jar