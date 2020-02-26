FROM openjdk:8-jdk-alpine
ARG JAR_FILE=backend/target/backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]