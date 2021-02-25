FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/upgrade

ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs							libs
ADD loan-application.xml                loan-application.xml

ADD healthcheck.sh                      healthcheck.sh

ENTRYPOINT sh healthcheck.sh


