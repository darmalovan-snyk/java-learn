#! /bin/bash
name=$1
web_port=$2
port=$3
docker run  -d --restart=always --name jenkins-${name} -p 0.0.0.0:${web_port}:8080 -p 0.0.0.0:${port}:50000 -v /data/docker/jenkins_home:/var/jenkins_home -v /etc/hosts:/etc/hosts  -u root  jenkins
