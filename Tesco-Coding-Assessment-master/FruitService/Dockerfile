FROM openjdk:17-alpine
COPY target/FruitService-*.jar fruit.jar
EXPOSE 8080
CMD ["java", "-jar", "fruit.jar"]