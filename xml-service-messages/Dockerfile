FROM maven:3.6.3-ibmjava-8-alpine AS message-dock

WORKDIR /usr/src/xml-service-messages
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /xml-service-messages
#COPY /usr/src/xml-service-messages/target/xml-service-messages-0.0.1-SNAPSHOT.jar ./
COPY --from=message-dock /usr/src/xml-service-messages/target/xml-service-messages-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "xml-service-messages-0.0.1-SNAPSHOT.jar"]