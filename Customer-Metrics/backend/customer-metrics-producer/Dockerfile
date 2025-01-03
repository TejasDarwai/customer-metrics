FROM openjdk:17-jdk-slim
COPY build/libs/customer-metrics-0.0.1-SNAPSHOT.jar customer-metrics-producer.jar
ENTRYPOINT ["java", "-jar", "/customer-metrics-producer.jar"]