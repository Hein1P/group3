FROM openjdk:latest
COPY ./target/group3.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group3.jar", "db:3306"]