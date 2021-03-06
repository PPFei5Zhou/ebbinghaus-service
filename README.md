# ebbinghaus-service

# Images pulled by Testcontainers itself to support functionality:
- [testcontainers/ryuk](https://hub.docker.com/r/testcontainers/ryuk) - performs fail-safe cleanup of containers, and always required (unless Ryuk is disabled)
- [alpine](https://hub.docker.com/_/alpine) - used to check whether images can be pulled at startup, and always required (unless startup checks are disabled)
- [testcontainers/sshd](https://hub.docker.com/r/testcontainers/sshd) - required if exposing host ports to containers
- [mysql 8.0.28-debian](https://hub.docker.com/_/mysql?tab=tags&page=1&name=8.0.28-debian) - mysql

# Prepare
- Docker

# Build and run
## Build spring boot
```shell
./gradlew clean build
```
## Unzip the project jar package
```shell
cd build/libs
jar -xf ebbinghaus-service.jar
cd ../..
```
## Build a Docker image
```shell
docker build -t ebbinghaus-service-docker .
```
## Run docker in local
```shell
docker run -d -p 8080:8080 -e "spring.profiles.active=local" ebbinghaus-service-docker
```
stop docker container
```shell
docker container stop ebbinghaus-service-docker
```
## Push to personal docker hub
### Tag the image name
```shell
docker tag ebbinghaus-service-docker 192.168.0.106/ebbinghaus-service-docker
```
### Push the image to docker hub
```shell
docker push 192.168.0.106/ebbinghaus-service-docker
```
### Pull the image to server
this command run in server
```shell
docker pull 192.168.0.106/ebbinghaus-service-docker
```
### Run docker in server
```shell
docker run -d -p 8080:8080 -e "spring.profiles.active=docker" --restart=always 192.168.0.106/ebbinghaus-service-docker
```
## Show spring boot log in docker
```shell
docker logs -f 192.168.0.106/ebbinghaus-service-docker
```