FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/cashwithdrawal-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} cashwithdrawal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cashwithdrawal-0.0.1-SNAPSHOT.jar"]