package com.hongjiaoliu.lcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liuhongjao
 * @date 2019/3/28 11:13
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerStart {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerStart.class, args);
	}
}
