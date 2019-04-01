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
	@GetMapping(value="add/{userID}/{role}")
	public Integer add1(@PathVariable("userID") Long userID,@PathVariable("role") Integer role){
		userRoleService.addUserRole(userID,role);
		return 1;
	}
	/**
	 * 代码错误，例如出现 20/0
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	@GetMapping(value="addWithRuntimeException/{userID}/{role}")
	public Integer addUserRoleWithRuntimeException(@PathVariable("userID") Long userID, @PathVariable("role") Integer role){
		userRoleService.addUserRoleWithRuntimeException(userID,role);
		return 2;
	}
	/**
	 * sql 错误
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:44
	 */
	@GetMapping(value="addWithSqlException/{userID}/{role}")
	public Integer addUserRoleWithSqlException(@PathVariable("userID") Long userID,@PathVariable("role") Integer role){
		userRoleService.addUserRoleWithSqlException(userID,role);
		return 3;
	}
}
