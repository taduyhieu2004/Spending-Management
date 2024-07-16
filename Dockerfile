#Build dependency
FROM maven:3.8.7 AS deps
ARG WORKDIR=/opt/app
WORKDIR ${WORKDIR}
COPY pom.xml .

RUN mvn dependency:go-offline

FROM maven:3.8.7 AS build-jar

ARG WORKDIR=/opt/app
WORKDIR ${WORKDIR}

COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app /opt/app
COPY src ./src

RUN mvn clean package -DskipsTests

FROM eclipse-temurin:17-jre-alpine AS extractor

ARG WORKDIR=/opt/app
WORKDIR ${WORKDIR}
COPY --from=build-jar /opt/app/target/*.jar .

ENTRYPOINT java -jar /opt/app/*.jar


