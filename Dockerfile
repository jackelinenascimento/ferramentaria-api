FROM azul/zulu-openjdk-alpine:11
VOLUME /tmp
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java","-jar","app.jar"]
