package com.hongjiaoliu.lcn;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liuhongjao
 * @date 2019/3/28 13:49
 */
@EnableEurekaClient
@SpringBootApplication
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
//通过次注解开启FeignClient请求的支持，spring提供的一种http请求方式
@MapperScan(basePackages = "com.hongjiaoliu.lcn.mapper")
@EnableDistributedTransaction
public class XcloudServiceCStart {

	public static void main(String[] args) {
		SpringApplication.run(XcloudServiceCStart.class, args);
	}

}
