# 空气质量环保公众监督平台

> 作者：[袁子俊]
### 简述
本项目为暑期实训项目，项目概述为空气质量环保公众监督平台旨在提升公众对环境保护的参与度，通过公众监督员对全国各地的空气质量进行监督，并由专业的网格员进行测量和数据上报。
平台集成了公众监督、网格测量、数据上报与统计分析等多项功能，确保空气质量数据的准确性和可靠性。管理员通过平台对网格员进行任务指派，并审核和统计测量数据，生成详细的报告和图表，供决策者参考。

### 相关技术
![image](https://github.com/user-attachments/assets/6b83363b-da00-4861-89dd-21294786bf3f)

### 项目结构
![image](https://github.com/user-attachments/assets/f8836ca4-e57f-41ee-b640-f49fccfb7ad0)

空气质量环保公众监督平台包括四个主要端：NEPS公众监督员端、NEPG检测网格员端、NEPM系统管理端和NEPV可视化大屏端，每个端有不同的业务功能。

### 功能分析
下面是该项目的功能图以及时序图
![image](https://github.com/user-attachments/assets/92f4e070-4ef4-4cd6-8144-b8bbaf248244)

![image](https://github.com/user-attachments/assets/75a7ddc5-bda9-4f8b-bf5f-e201ad13fb7b)

### 详细设计
下面的类图展示了系统中的主要类及其属性和方法，以及类之间的关系。
![image](https://github.com/user-attachments/assets/d30e92b0-1078-4e44-a3c4-565b97fc6a0d)

数据库设计方面，考虑到：  
1、根据业务需求和功能模块，设计合理的数据库表结构，确保数据的存储和访问高效、可靠。各表之间通过外键建立关联，保证数据的一致性和完整性。例如，Feedback表中的supervisorId字段作为外键关联到Supervisor表。  
2、遵循数据库设计的规范化原则，确保数据的存储结构合理，避免数据冗余和异常。使用规范的命名规则，如表名和字段名的命名统一、简洁、易懂，便于后期维护和扩展。  
3、采用分布式事务管理机制，引入Seata架构，确保数据操作的一致性和完整性。在涉及多个表的操作时，通过事务保证所有操作要么全部成功，要么全部回滚。  
![image](https://github.com/user-attachments/assets/c9688085-a6b2-4a0c-9672-80b31da9c765)

### 相关页面展示
该项目有四个端，难以全部展示，这里以部分的业务页面作为展示：  
#### 监督员登录
![image](https://github.com/user-attachments/assets/f4f1cb1a-94ff-4a0d-99a0-21cec5042b7c)
#### 监督员注册
![image](https://github.com/user-attachments/assets/d3ad30a8-08f7-468a-9de1-9e5712aebb22)
#### 监督员主页面
![image](https://github.com/user-attachments/assets/e1c61cd4-fada-4573-a33d-f5ec2c9e7c35)
#### 历史反馈信息
![image](https://github.com/user-attachments/assets/f97f6896-d82a-4c86-9073-90a474382520)
#### 上报信息
![image](https://github.com/user-attachments/assets/e6960a1f-212b-4dde-9ccc-40e5e7f0a798)
#### 个人信息操作
![image](https://github.com/user-attachments/assets/c8269879-c457-4e3e-ad83-e944b6c73088)
#### 数据大屏展示
![image](https://github.com/user-attachments/assets/4288d33a-1fd4-451b-b9b5-fef7b137dd48)

### 微服务架构
我们将整个系统划分为多个独立的微服务，每个微服务负责不同的业务功能。这样可以确保各个微服务的独立性和高内聚性，同时通过轻量级的通信机制（通常是HTTP/REST）进行交互，确保系统的灵活性和可扩展性。  
![image](https://github.com/user-attachments/assets/4057f8ca-292b-49a3-8728-1ba17afa3239)

微服务全部启动  
![image](https://github.com/user-attachments/assets/77ceee05-3a2b-40fc-890d-4c29c05637a6)

#### Nacos服务与配置管理
![image](https://github.com/user-attachments/assets/cb9f24b0-29ad-4b05-960e-6125865189bc)
![image](https://github.com/user-attachments/assets/a6917436-75da-4177-8ac2-30796435a9a9)

#### Sentinel流量控制
![image](https://github.com/user-attachments/assets/0f40ad6a-a7eb-4c48-8b24-2f0885997beb)

#### Linux部署
使用阿里云的服务器来支持部署  
![image](https://github.com/user-attachments/assets/57f5c73a-b7a3-41ec-b8ba-0db5ef6babb7)

使用了Docker-compose的方式来部署，从而减少在部署过程中服务器要多次下载镜像的繁琐操作，给后端的每一个独立可运行的微服务（例如supervisor-service）项目下创建了Dockerfile文件，用于每个项目的Docker运行指向。  
![image](https://github.com/user-attachments/assets/56cf97ee-1373-4877-a309-0ea0439bdb2b)

所有配置文件编写完成后，使用Idea的SFTP功能根据服务器IP、账户以及密码连接到云服务器。  
![image](https://github.com/user-attachments/assets/acaf306c-f7c1-4fc8-bc8a-7c8c7c897641)

成功上传至云服务器  
![image](https://github.com/user-attachments/assets/7b87073e-22b1-4b4e-8928-c7fef73535ac)

下载相关依赖，对项目打包和运行。  
![image](https://github.com/user-attachments/assets/7401d23d-5949-471b-9fbe-7d14d3ed748d)
![image](https://github.com/user-attachments/assets/529e91b8-6ff9-4e68-b59d-629288c16913)

### 具体技术
#### PageHelper + ElasticSearch
![image](https://github.com/user-attachments/assets/127e11d2-7945-4cd1-8536-abf06a1ddd7b)
#### JWT
![image](https://github.com/user-attachments/assets/8eb44ec1-a993-40e8-802a-e9904cd6d811)
#### 云数据库
![image](https://github.com/user-attachments/assets/ebbe755e-9504-46be-8379-94842e481cab)
#### Pinia状态管理、MD5
![image](https://github.com/user-attachments/assets/d7cd247b-c329-4249-9a57-865e5bcb1b71)



