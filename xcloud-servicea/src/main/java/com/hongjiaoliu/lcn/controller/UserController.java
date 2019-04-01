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
	 * 场景1 描述：S1-> S2 -> S3
	 * 		S1、S2、S3 服务代码均正确
	 * 	预期结果：S1、S2、S3均可顺利提交事务
	 * @param name
	 * @param age
	 */
	@GetMapping(value="s1ToS2ToS3/{name}/{age}")
	public Integer s1ToS2ToS3(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.s1ToS2ToS3(name,age);
		return 1;
	}

	/**
	 *  场景2 描述：S1-> S2 -> S3
	 * 		S1 服务代码正确，S2 出现运行时异常，S3服务代码正确
	 * 	预期结果：S1、S2 事务回滚，不调用S3
	 * @param name
	 * @param age
	 */
	@GetMapping(value="s1ToS2withRuntimeExceptionToS3/{name}/{age}")
	public Integer s1ToS2withRuntimeExceptionToS3(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.s1ToS2withRuntimeExceptionToS3(name,age);
		return 2;
	}

	/**
	 * 场景3 描述： S1-> S2 -> S3
	 * 		S1、S2  服务代码正确，S3 服务出现异常
	 * 	预期结果：S1、S2、S3 事务回滚
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/4/1 15:48
	 */
	@GetMapping(value="s1ToS2ToS3WithRuntimeException/{name}/{age}")
	public Integer s1ToS2ToS3WithRuntimeException(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.s1ToS2ToS3WithRuntimeException(name,age);
		return 3;
	}

	/**
	 * 场景4 描述： S1-> S2 -> S3
	 * 		S1 服务在调用S2 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
	 * 	预期结果：	S1、S2 事务回滚，不调用S3
	 * @param name
	 * @param age
	 */
	@GetMapping(value="s1WithExceptionAfterCallS2/{name}/{age}")
	public Integer s1WithExceptionAfterCallS2(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.s1WithExceptionAfterCallS2(name,age);
		return 3;
	}

	/**
	 * 场景5 描述： S1-> S2 -> S3
	 *  	S1 服务在调用S3 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
	 *  预期结果：	S1、S2 、S3 事务回滚
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/4/1 15:58
	 */
	@GetMapping(value="s1WithExceptionAfterCallS3/{name}/{age}")
	public Integer s1WithExceptionAfterCallS3(@PathVariable("name") String name,@PathVariable("age") Integer age){
		userService.s1WithExceptionAfterCallS3(name,age);
		return 3;
	}



}
