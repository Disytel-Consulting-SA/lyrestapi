FROM openjdk:8-jdk-alpine

COPY build/libs/lyrestapi-1.0.0.jar lyrestapi-1.0.0.jar

COPY libs/JasperReports-ngroovy.jar JasperReports-ngroovy.jar
ENTRYPOINT ["java","-Dloader.path=/JasperReports-ngroovy.jar","-jar","/lyrestapi-1.0.0.jar"]