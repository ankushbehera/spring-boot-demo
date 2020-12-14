FROM maven:3.6-jdk-11
RUN ["sh","docker_mvn.sh"]
WORKDIR /usr/src/spring-boot-demo
