FROM maven:3.6.3-ibmjava-8-alpine AS user-dock

WORKDIR /usr/src/xml-service-user
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /xml-service-user
COPY --from=user-dock /usr/src/xml-service-user/target/xml-service-user-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "xml-service-user-0.0.1-SNAPSHOT.jar"]