FROM openjdk:8-jdk-alpine
COPY entrypoint.sh /entrypoint.sh
COPY target/xml-service-messages-0.0.1-SNAPSHOT.jar messages-0.0.1.jar
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]
