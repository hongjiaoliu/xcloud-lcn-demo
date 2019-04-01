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
用户角色添加模拟场景
+ S1服务为用户服务,处理mysql中的User表逻辑；
+ S2服务为用户角色服务，处理mysql中User_Role表逻辑；
+ S3服务为日志服务，处理mongoDB中日志Task_log表的逻辑;

# 请求明细

+ 场景1：S1-> S2 -> S3，S1、S2、S3 服务代码均正确
    + 请求地址：127.0.0.1:11201/user/s1ToS2ToS3/abc/25
    + 预期结果：：S1、S2、S3均可顺利提交事务
+ 场景2：S1-> S2 -> S3，S1 服务代码正确，S2 出现运行时异常，S3服务代码正确
    + 请求地址：127.0.0.1:11201/user/s1ToS2withRuntimeExceptionToS3/abc/25
    + 预期结果：S1、S2 事务回滚，不调用S3
+ 场景3：S1-> S2 -> S3，S1、S2  服务代码正确，S3 服务出现异常
    + 请求地址：127.0.0.1:11201/user/s1ToS2ToS3WithRuntimeException/abc/25
    + 预期结果：S1、S2、S3 事务回滚
+ 场景4:  S1-> S2 -> S3 , S1 服务在调用S2 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
    + 请求地址：127.0.0.1:11201/user/s1WithExceptionAfterCallS2/abc/25
    + 预期结果：S1、S2 事务回滚，不调用S3
+ 场景5：S1-> S2 -> S3 ， S1 服务在调用S3 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
    + 请求地址：127.0.0.1:11201/user/s1WithExceptionAfterCallS3/abc/25
    + 预期结果：S1、S2 、S3 事务回滚
    