FROM maven:3.6.3-ibmjava-8-alpine AS vozilo-dock

WORKDIR /usr/src/xml-service-vozilo
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /xml-service-vozilo
COPY --from=vozilo-dock /usr/src/xml-service-vozilo/target/xml-service-vozilo-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "xml-service-vozilo-0.0.1-SNAPSHOT.jar"]