cd /usr/src
git clone https://github.com/ankushbehera/spring-boot-demo.git
cd /usr/src/spring-boot-demo
git fetch origin
git rebase origin
mvn package -DskipTests