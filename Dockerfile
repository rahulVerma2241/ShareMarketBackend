# Image of the java 17
FROM openjdk:17-slim
# Copy file
COPY target/ShareMarketBackend-0.0.1-SNAPSHOT.jar /ShareMarketBackend.jar
# Expose the port


CMD ["java" , "-jar", "/ShareMarketBackend.jar"]
