FROM tomcat:8.5.46-jdk8-openjdk

RUN apt-get update
RUN apt-get install -y tzdata
ENV TZ=Asia/Seoul

CMD ["catalina.sh", "run"]
