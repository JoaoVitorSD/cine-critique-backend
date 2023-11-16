FROM openjdk:17-jdk-bullseye

COPY . /usr/app

WORKDIR /usr/app

RUN apt-get update && apt-get install -y maven

RUN mvn clean install

entrypoint ["java", "-jar", "target/*.jar"]