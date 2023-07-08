FROM openjdk:17-alpine
COPY target/StockService-*.jar stock.jar
EXPOSE 8080
CMD ["java", "-jar", "stock.jar"]