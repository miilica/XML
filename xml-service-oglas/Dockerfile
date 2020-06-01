FROM maven:3.6.3-ibmjava-8-alpine AS oglas-dock

WORKDIR /usr/src/xml-service-oglas
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /xml-service-oglas
COPY --from=oglas-dock /usr/src/xml-service-oglas/target/xml-service-oglas-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "xml-service-oglas-0.0.1-SNAPSHOT.jar"]