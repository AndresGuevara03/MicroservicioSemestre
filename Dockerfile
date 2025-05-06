FROM openjdk:23
LABEL authors="david"
WORKDIR /app
COPY target/SemestreService-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "SemestreService-0.0.1-SNAPSHOT.jar"]