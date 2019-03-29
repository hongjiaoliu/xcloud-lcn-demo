#The Demo Project for Learning LCN distributed transaction in spring cloud  

> [引用:https://txlcn.org/zh-cn/docs/background.html](https://txlcn.org/zh-cn/docs/background.html)

# 环境依赖
+ Jdk
+ Redis 
+ Mysql 

# 项目列表
1. Eureka ：**xcloud-eureka** , Spring cloud 服务发现注册中心。
2. TM ：**xcloud-tm**, 事务管理服务，可注册也可不注册到eurake。
3. TC(S1) ：  **xcloud-servicea** ，注册到eureka中，服务名称为S1，处理Mysql数据库逻辑。
4. TC(S2) ：  **xcloud-serviceb**，注册到eureka中，服务名称为S2，处理Mysql数据库逻辑。
5. TC(S3) ：  **xcloud-serviceb**，注册到eureka中，服务名称为S3, 处理非关系型数据库逻辑，redis、mongodb等。

# 模拟场景
