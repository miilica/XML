FROM maven:3.6.3-ibmjava-8-alpine AS agentska

WORKDIR /usr/src/xml-service
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /xml-service
#COPY /usr/src/xml-service/target/demo-0.0.1-SNAPSHOT.jar ./
COPY --from=agentska /usr/src/xml-service/target/demo-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]