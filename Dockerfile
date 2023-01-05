#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
EXPOSE 8080
COPY  --from=build target/docker-user-mgmt-1.0.0.jar UserManagement-0.0.1-SNAPSHOT.jar
CMD [java,-jar,/UserManagement-0.0.1-SNAPSHOT.jar]
