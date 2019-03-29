package com.hongjiaoliu.lcn.controller;

import com.hongjiaoliu.lcn.service.UserService;
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
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	/**
	 * 场景1 ： S1 服务代码正确，S2 服务代码正确，------> S1 和 S2均可以顺利提交事务
	 * @param name
	 * @param age
	 */
	@GetMapping(value="add1/{name}/{age}")
	public Integer add(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.addUser1(name,age);
		return 1;
	}
	/**
	 * 场景2 ： S1 服务代码正确，S2 出现运行时异常，-------> S1 和 S2 事务回滚
	 * @param name
	 * @param age
	 */
	@GetMapping(value="add2/{name}/{age}")
	public Integer add2(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.addUser2(name,age);
		return 1;
	}

	/**
	 * 场景3：  S1 服务在调用S2 服务后出现运行时异常，S2 服务代码正确 -------->
	 * @param name
	 * @param age
	 */
	@GetMapping(value="add3/{name}/{age}")
	public Integer add3(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.addUser3(name,age);
		return 1;
	}

}
