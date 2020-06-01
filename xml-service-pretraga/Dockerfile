FROM openjdk:8-jdk-alpine
COPY entrypoint.sh /entrypoint.sh
COPY target/xml-service-pretraga-0.0.1-SNAPSHOT.jar pretraga-0.0.1.jar
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]
