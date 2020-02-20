FROM openjdk:13-slim
COPY build/libs/micronaut-example-*-all.jar app.jar
EXPOSE 8081
CMD java --enable-preview -XX:+UseContainerSupport -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar app.jar