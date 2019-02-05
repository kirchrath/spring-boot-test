#!/bin/sh

mvn clean package
docker build . -t=kirchrath/spring-boot-test:latest -t=kirchrath/spring-boot-test:$(date +%Y%m%d%H%M%S)
docker push kirchrath/spring-boot-test
