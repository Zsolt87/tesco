FROM openjdk:17-alpine
COPY target/FruitAggregatorService*.jar fruit_aggregator.jar
EXPOSE 8080
CMD ["java", "-jar", "fruit_aggregator.jar"]