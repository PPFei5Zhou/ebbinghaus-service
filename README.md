# ebbinghaus-service

# Images pulled by Testcontainers itself to support functionality:
- [testcontainers/ryuk](https://hub.docker.com/r/testcontainers/ryuk) - performs fail-safe cleanup of containers, and always required (unless Ryuk is disabled)
- [alpine](https://hub.docker.com/_/alpine) - used to check whether images can be pulled at startup, and always required (unless startup checks are disabled)
- [testcontainers/sshd](https://hub.docker.com/r/testcontainers/sshd) - required if exposing host ports to containers
- [mysql 8.0.28-debian](https://hub.docker.com/_/mysql?tab=tags&page=1&name=8.0.28-debian) - mysql