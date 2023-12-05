# Kafka Consumer Monitoring with Micrometer

## Overview
This project is a proof of concept for monitoring a Kafka consumer using Micrometer with Java, Spring Boot, and Maven. The goal is to showcase how to integrate Micrometer into a Spring Boot application to collect and expose metrics related to Kafka consumption. The project includes a simple Kafka consumer that subscribes to a Kafka topic and processes messages.

## Prerequisites
- Java JDK (version 8 or later)
- Maven
- Apache Kafka

Note: Ensure that your Kafka topic exists and is producing messages for the consumer to consume.

## Getting Started

1. **Clone the repository**
 ```bash
 git clone <repository_url>
 cd kafka-consumer-monitoring
 ```

2. **Build the Project**
```bash
mvn clean install
```

3. **Run the Project**
```bash
mvn spring-boot:run
```

## Spring Project Configuration 
Update the application.yml file to configure Kafka and Micrometer settings:
```
spring:
  application:
    name: kafka-monitoring
  cloud:
    config:
      enabled: false
  jmx:
    enabled: true
kafka:
  bootstrapAddress: localhost:9092
  groupId: the-group
  topicName: the-topic
management:
  endpoint:
    metrics:
      enabled: true
    prometheus:
      enabled: true
  endpoints:
    jmx:
      exposure:
        include: "*"
    web:
      exposure:
        include: metrics,info,health,prometheus
  metrics:
    tags:
      application: ${spring.application.name}
    export:
      jmx:
        enabled: true
  info:
    env:
      enabled: true
  ```

## Micrometer Integration
Once the application is running, you can access the Micrometer metrics at the following endpoint:
```bash
http://localhost:8080/actuator/prometheus
```

