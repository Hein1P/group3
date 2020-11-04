FROM openjdk:latest
COPY ./target/group3-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group3-1.0-SNAPSHOT-jar-with-dependencies.jar"]
