FROM openjdk:17
COPY target/ShareMarketBackend-0.0.1-SNAPSHOT.jar marketbackend.jar
ENTRYPOINT ["java","-jar","/marketbackend.jar"]