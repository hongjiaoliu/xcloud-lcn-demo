package com.hongjiaoliu.lcn.controller;

import com.hongjiaoliu.lcn.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhongjao
 * @date 2019/3/28 14:15
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;

	/**
	 * 正确逻辑
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	@GetMapping(value="add1/{userID}/{role}")
	public Integer add1(@PathVariable("userID") Long userID,@PathVariable("role") Integer role){
		userRoleService.addUserRole1(userID,role);
		return 1;
	}
	/**
	 * 代码错误，例如出现 20/0
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	@GetMapping(value="add2/{userID}/{role}")
	public Integer add2(@PathVariable("userID") Long userID,@PathVariable("role") Integer role){
		userRoleService.addUserRole2(userID,role);
		return 2;
	}
	/**
	 * sql 错误
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:44
	 */
	@GetMapping(value="add3/{userID}/{role}")
	public Integer add3(@PathVariable("userID") Long userID,@PathVariable("role") Integer role){
		userRoleService.addUserRole3(userID,role);
		return 3;
	}
}
