# 使用官方的OpenJDK镜像作为基础镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 将本地的JAR文件复制到镜像中
ADD target/supervisor-service-0.0.1-SNAPSHOT.jar .

# 暴露应用程序的端口
EXPOSE 9081

# 定义启动命令
ENTRYPOINT ["java", "-jar", "/app/supervisor-service-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
