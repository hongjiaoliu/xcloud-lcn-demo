package com.hongjiaoliu.lcn;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liuhongjao
 * @date 2019/3/28 13:49
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
@MapperScan(basePackages = "com.hongjiaoliu.lcn.mapper")
@EnableDistributedTransaction
public class XcloudServiceAStart {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(XcloudServiceAStart.class);
//		springApplication.setBanner(new XXBanner());
		springApplication.run(args);
	}
}
