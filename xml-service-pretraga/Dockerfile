FROM maven:3.6.3-ibmjava-8-alpine AS pretraga-dock

WORKDIR /usr/src/xml-service-pretraga
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /xml-service-pretraga
COPY --from=pretraga-dock /usr/src/xml-service-pretraga/target/xml-service-pretraga-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "xml-service-pretraga-0.0.1-SNAPSHOT.jar"]