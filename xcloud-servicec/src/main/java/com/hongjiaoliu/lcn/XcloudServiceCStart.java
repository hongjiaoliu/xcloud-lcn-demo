package com.hongjiaoliu.lcn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liuhongjao
 * @date 2019/3/28 13:49
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.hongjiaoliu.lcn.mapper")
public class XcloudServiceCStart {

	public static void main(String[] args) {
		SpringApplication.run(XcloudServiceCStart.class, args);
	}

}
