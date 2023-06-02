FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY build/libs/java-micronaut-rest-1.0-SNAPSHOT-all.jar javamicronautrest.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar javamicronautrest.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar javamicronautrest.jar
