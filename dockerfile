FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/cashwithdrawal-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} cashwithdrawal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cgtest-0.0.1-SNAPSHOT.jar"]