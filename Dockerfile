# Image of the java 25
FROM amazoncorretto:25.0.2
# Copy file
COPY target/ShareMarketBackend-0.0.1-SNAPSHOT.jar /ShareMarketBackend.jar
# Expose the port
CMD ["java" , "-jar", "/ShareMarketBackend.jar"]
