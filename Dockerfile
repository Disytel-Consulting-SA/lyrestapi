FROM openjdk:8-jdk-alpine

COPY build/libs/lyrestapi-1.0.0.jar lyrestapi-1.0.0.jar

ENTRYPOINT ["java","-jar","/lyrestapi-1.0.0.jar"]