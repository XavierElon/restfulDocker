FROM adoptopenjdk/openjdk8:ubi

WORKDIR /opt/app

ARG LOCAL_FOLDER=./

COPY ${LOCAL_FOLDER} restfulDocker



