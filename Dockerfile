# Step 1 Download from Github
FROM alpine/git as download-step
LABEL maintainer "Rafael Fonseca <rfonseca85@yahoo.ca>"
#Download and build Backend
RUN mkdir /home/jahia-contacts-api
RUN cd /home/jahia-contacts-api 
RUN git clone https://github.com/rfonseca85/jahia-contacts-api.git /home/jahia-contacts-api

# Step 2 Build & Run Backend
FROM adoptopenjdk:11-jdk-hotspot-bionic as build-backend-step
LABEL maintainer "Rafael Fonseca <rfonseca85@yahoo.ca>" 
EXPOSE 9090
RUN mkdir /home/jahia-contacts-api
COPY --from=download-step /home/jahia-contacts-api /home/jahia-contacts-api
WORKDIR /home/jahia-contacts-api 
RUN ./gradlew clean test assemble
WORKDIR /home/jahia-contacts-api/build/libs
ENTRYPOINT ["java","-jar","jahia-contacts-api-0.0.1-SNAPSHOT.jar"]
