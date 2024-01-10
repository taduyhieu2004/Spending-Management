#FROM maven AS build-dependency
#WORKDIR /opt/app-dev
#COPY quanlichitieu/src ./quanlichitieu/src
#COPY quanlichitieu/pom.xml ./quanlichitieu/pom.xml
#COPY quanlichitieu/.mvn ./quanlichitieu/.mvn
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17-oracle
#WORKDIR /opt/app-dev
#COPY --from=build-dependency opt/app-dev/release/*.jar .
#COPY --from=build-dependency opt/app-dev/release/lib ./lib
#
#ENTRYPOINT java -jar /opt/app-dev/*.jar