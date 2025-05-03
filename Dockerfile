FROM openjdk:17-jdk-alpine

LABEL MAINTAINER "DEVDUTT JATAV"

EXPOSE 8080

COPY target/WelcomeRestApp.jar /usr/app

WORKDIR /usr/app

ENTRYPOINT [ "java","-jar","WelcomeRestApp.jar" ]