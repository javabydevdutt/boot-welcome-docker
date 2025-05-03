FROM openjdk:17-jdk-alpine

LABEL MAINTAINER "DEVDUTT JATAV"

EXPOSE 8080

COPY target/WelcomeRestApp.jar WelcomeRestApp.jar

ENTRYPOINT [ "java","-jar","WelcomeRestApp.jar" ]
