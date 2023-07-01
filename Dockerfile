FROM eclipse-temurin:19-jdk-jammy
COPY /target/redis-cache-0.0.1-SNAPSHOT.jar redis-cache-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","redis-cache-0.0.1-SNAPSHOT.jar"]