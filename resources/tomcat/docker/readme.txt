-----------------------------
-- 톰캣 도커환경 구성
-----------------------------

1. 도커 이미지 빌드

    1) Dockerfile 작성한다. 
        [Dockerfile]
            FROM tomcat:8.5.46-jdk8-openjdk
            RUN apt-get update
            RUN apt-get install -y tzdata
            ENV TZ=Asia/Seoul
            CMD ["catalina.sh", "run"]

    2) 작성한 Dockerfile 저장 위치에서 아래 도커 명령을 수행하여 이미지를 빌드한다.
        
        docker build -t tomcat8:v1.0 . 

    3) docker-compose.yml 파일을 작성한다.(컨테이너 서비스 설정 파일)
        [docker-compose.yml]
            version: '1.0'

            services:
            mint:
                container_name: iip-container
                image: tomcat8:v1.0
                environment:
                - TZ=Asia/Seoul
                volumes:
                - /Users/whoana/DEV/docker-home/tomcat8/logs:/usr/local/tomcat/logs
                - /Users/whoana/DEV/docker-home/tomcat8/upload:/usr/local/tomcat/upload
                - /Users/whoana/DEV/docker-home/tomcat8/logback/logback.xml:/usr/local/tomcat/logback/logback.xml
                - /Users/whoana/DEV/docker-home/tomcat8/bin/catalina.sh:/usr/local/tomcat/bin/catalina.sh
                - /Users/whoana/DEV/docker-home/tomcat8/conf/server.xml:/usr/local/tomcat/conf/server.xml
                - /Users/whoana/DEV/docker-home/tomcat8/conf/context.xml:/usr/local/tomcat/conf/context.xml
                - /Users/whoana/DEV/docker-home/tomcat8/webapps/mint-front-product-3.0.0.war:/usr/local/tomcat/webapps/mint.war
                - /Users/whoana/DEV/docker-home/tomcat8/lib/ojdbc6-11.2.0.3.jar:/usr/local/tomcat/lib/ojdbc6-11.2.0.3.jar
                ports:
                - 18080:8080
    
    4) docker-compose.yml 파일 상의 볼륨 값에 매핑된 파일 구성  
        참조한 tomcat8 디렉토리 값 이용.

    5) 톰캣 도커 컨테이너 실행 
        docker-compose up -d

    6) 톰캣 도커 컨테이너 로그 확인  
        docker-compose logs -f

    7) 톰캣 도커 컨테이너 접속
        docker exec -it iip-container /bin/bash

    8) 톰캣 도커 컨테이너 종료 
        docker-compose down
