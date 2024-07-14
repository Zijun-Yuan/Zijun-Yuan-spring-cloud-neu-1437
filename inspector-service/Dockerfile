# 使用官方的OpenJDK镜像作为基础镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 将本地的JAR文件复制到镜像中
ADD target/inspector-service-0.0.1-SNAPSHOT.jar .

# 暴露应用程序的端口
EXPOSE 9082

# 定义启动命令
ENTRYPOINT ["java", "-jar", "/app/inspector-service-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
