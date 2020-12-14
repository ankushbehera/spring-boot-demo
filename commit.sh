message=$1
if [ -z "$message" ]; then
    message="added by script"
fi
git add .
git commit -a -m "$message"
git push
CONTAINER_ID=$(docker container ls -aqf "name=run-spring-boot-demo")
winpty docker exec -it $CONTAINER_ID bash docker/docker_mvn.sh