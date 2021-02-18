FROM openjdk:11-jdk-slim
LABEL maintainer "Rafael Fonseca <rfonseca85@yahoo.ca>"
WORKDIR /api
ADD . .
RUN ./gradlew clean test assemble
WORKDIR /api/build/libs
EXPOSE 9090
ENTRYPOINT ["java","-jar","jahia-contacts-api-0.0.1-SNAPSHOT.jar"]



