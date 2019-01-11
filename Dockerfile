FROM openjdk:8-jdk-alpine

COPY ./target/spring-test-*.jar app.jar

EXPOSE 8080
EXPOSE 4444

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
