package com.hongjiaoliu.lcn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/28 21:40
 */
@FeignClient(name = "S2")
public interface ServiceBClient {

	/**
	* 正确逻辑
	* @return:
	* @author:liuhongjiao
	* @date: 2019/3/29 16:43
	*/
	@GetMapping(value="userRole/add1/{userID}/{role}")
	public Integer addUserRole1(@PathVariable("userID") Long userID,@PathVariable("role") Integer role);

	/**
	* 代码错误，例如出现 20/0
	* @return:
	* @author:liuhongjiao
	* @date: 2019/3/29 16:43
	*/
	@GetMapping(value="userRole/add2/{userID}/{role}")
	public Integer addUserRole2(@PathVariable("userID") Long userID,@PathVariable("role") Integer role);

	/**
	* sql 错误
	* @return:
	* @author:liuhongjiao
	* @date: 2019/3/29 16:44
	*/
	@GetMapping(value="userRole/add3/{userID}/{role}")
	public Integer addUserRole3(@PathVariable("userID") Long userID,@PathVariable("role") Integer role);
}
