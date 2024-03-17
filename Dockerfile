FROM ubuntu-debootstrap:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN .mvn/wrapper/maven-wrapper.jar  --no-daemon
FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY .. src/main/java/in/suman/WebMvcApp05Application.jar/WebMvcApp05Application
ENTRYPOINT [ "JAVA","-JAR"WebMvcApp05Application.jar ]