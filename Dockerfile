FROM centos:7

MAINTAINER bwensun bwensun@foxmail.com

## 安装jdk
RUN echo "ip_resolve=4" >> /etc/yum.conf
RUN yum update -y && yum install -y java-11-openjdk-devel

# 设置时区。这对于日志、调用链等功能能否在 TSF 控制台被检索到非常重要。
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
COPY /data/actions-runner/_work/Remind/Remind/target/remind.jar /remind.jar

CMD ["--server.port=9001"]

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "/remind.jar"]