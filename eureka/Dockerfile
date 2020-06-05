FROM maven:3.6.3-ibmjava-8-alpine AS eureka-dock

WORKDIR /usr/src/eureka
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /eureka
COPY --from=eureka-dock /usr/src/eureka/target/eureka-0.0.1-SNAPSHOT.jar ./

EXPOSE 8761

CMD ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar"]