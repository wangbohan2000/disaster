FROM openjdk:11.0.9.1-jre-buster

LABEL maintainer="Wang Bohan <wbhan_cn@qq.com>"

ADD ./disaster-1.0.0-beta.jar /disaster.jar

ENTRYPOINT [ "java", "-jar", "/disaster.jar", "--server.port=80" ]