./gradlew bootJar
docker build -t main .
docker run -p 8080:8080 main
