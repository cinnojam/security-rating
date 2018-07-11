# security-rating
## Maven
mvn clean install
## Docker
### build
docker build . --build-arg JAR_FILE=./target/security-rating-0.0.1-SNAPSHOT.jar -t cinnojam/security-rating:latest
### run
docker run -d -p 8081:8081 cinnojam/security-rating:latest
### test
curl http://localhost:8081/security-rating/ratings
### stop
docker ps
docker stop <container id>
### tag
docker tag security-rating cinnojam/security-rating:latest
### share: docker push <user name>/<repo name>:<tag name>
docker login -u user -p pwd
docker push cinnojam/security-rating:latest
## Docker Compose
### build
docker-compose build
### run
docker-compose up
### test
curl http://localhost:8081/security-rating/ratings
### stop
docker-compose down
### share
docker-compose push
