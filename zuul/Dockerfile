FROM maven:3.6.3-ibmjava-8-alpine AS zuul-dock

WORKDIR /usr/src/zuul
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine
WORKDIR /zuul
COPY --from=zuul-dock /usr/src/zuul/target/zuul-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "zuul-0.0.1-SNAPSHOT.jar"]
