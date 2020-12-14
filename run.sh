git add .
git commit -a -m "$1"
git push
CONTAINER_ID=$(docker container ls -aqf "name=run-spring-boot-demo")
winpty docker exec -it $CONTAINER_ID bash docker/docker_mvn.sh