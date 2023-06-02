FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8181
ARG JAR_FILE=target/cashwithdrawal-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} cashwithdrawal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cashwithdrawal-0.0.1-SNAPSHOT.jar"]