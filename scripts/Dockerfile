FROM openjdk:17

WORKDIR /app

COPY ./target/*.jar /app/demo.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app/demo.jar

