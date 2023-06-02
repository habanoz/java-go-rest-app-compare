./gradlew bootJar
docker build -t main .
docker run -p 8080:8080 main

or for native image
./gradlew bootBuildImage
docker run -p 8080:8080 'docker.io/library/java-spring-rest:0.0.1-SNAPSHOT'