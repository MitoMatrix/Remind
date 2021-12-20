FROM centos:7

MAINTAINER bwensun bwensun@foxmail.com

## 安装jdk
RUN echo "ip_resolve=4" >> /etc/yum.conf
RUN yum update -y && yum install -y java-11-openjdk-devel

# 设置时区。这对于日志、调用链等功能能否在 TSF 控制台被检索到非常重要。
RUN echo "Asia/shanghai" > /etc/timezone

ENV workdir /app/

COPY /target/remind.jar ${workdir}

CMD ["--server.port=9001"]

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "/app/remind.jar"]