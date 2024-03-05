FROM openjdk:17

WORKDIR /usr/src/app

COPY target/tmdbapi-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "tmdbapi-0.0.1-SNAPSHOT.jar"]