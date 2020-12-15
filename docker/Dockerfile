FROM maven:3.6-jdk-11
WORKDIR /usr/src
RUN git clone https://github.com/ankushbehera/spring-boot-demo.git
WORKDIR /usr/src/spring-boot-demo/docker
RUN ["sh","docker_mvn.sh"]
WORKDIR /usr/src/spring-boot-demo