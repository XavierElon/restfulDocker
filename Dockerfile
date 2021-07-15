FROM adoptopenjdk/openjdk8:ubi

WORKDIR /opt/app

ARG JAR_FILE=target/HelloRESTful-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]