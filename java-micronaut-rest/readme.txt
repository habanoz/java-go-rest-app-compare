./gradlew assemble
docker build -t main .
docker run -p 8080:8080 main

or native image
./gradlew dockerBuildNative
docker run -p 8080:8080 java-micronaut-rest:latest