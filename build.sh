#!/bin/sh

mvn clean package
docker build . -t=kirchrath/spring-boot-test
docker push kirchrath/spring-boot-test
