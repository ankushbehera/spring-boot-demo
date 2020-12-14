cd /usr/src/spring-boot-demo/docker
git fetch origin
git rebase origin
cd /usr/src/spring-boot-demo/
mvn package -DskipTests