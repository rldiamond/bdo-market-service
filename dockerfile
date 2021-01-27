FROM openjdk:8-jre-alpine

COPY build/libs/bdo-market-service-0.0.1.jar /service.jar

CMD ["/usr/bin/java", "-jar", "/service.jar"]