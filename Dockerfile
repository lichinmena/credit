FROM openjdk:8-jdk-slim
COPY "./target/credit-0.0.1-SNAPSHOT.jar" "credit.jar"
EXPOSE 8081
ENTRYPOINT  ["java", "-jar", "credit.jar"]