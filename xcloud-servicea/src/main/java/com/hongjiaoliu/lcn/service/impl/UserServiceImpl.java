package com.hongjiaoliu.lcn.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.hongjiaoliu.lcn.client.ServiceBClient;
import com.hongjiaoliu.lcn.client.ServiceCClient;
import com.hongjiaoliu.lcn.entity.User;
import com.hongjiaoliu.lcn.mapper.UserMapper;
import com.hongjiaoliu.lcn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author liuhongjao
 * @date 2019/3/28 21:17
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Autowired
	ServiceBClient serviceBClient;

	@Autowired
	ServiceCClient  serviceCClient;

	/**
	 * 场景1 ： S1 服务代码正确，S2 服务代码正确，------> S1 和 S2均可以顺利提交事务
	 * @param name
	 * @param age
	 */
	@Override
	@LcnTransaction //分布式事务注解
	@Transactional //本地事务注解
	public void s1ToS2ToS3(String name, Integer age) {
		User u = new User();
		u.setAge(age);
		u.setName(name);
		userMapper.add(u);
		Long userID = u.getId();
		serviceBClient.addUserRole(userID,3);
		serviceCClient.add("a-b-c success");
	}

	/**
	 * 场景2 ： S1 服务代码正确，S2 出现运行时异常，-------> S1 和 S2 事务回滚
	 * @param name
	 * @param age
	 */
	@Override
	@LcnTransaction //分布式事务注解
	@Transactional //本地事务注解
	public void s1ToS2withRuntimeExceptionToS3(String name, Integer age) {
		User u = new User();
		u.setAge(age);
		u.setName(name);
		userMapper.add(u);
		Long userID = u.getId();
		serviceBClient.addWithRuntimeException(userID,3);
//		serviceBClient.addWithSqlException(new Long(userID),3);
		serviceCClient.add("a-b-c success");
	}

	/**
	 * 场景3：  S1 服务在调用S2 服务后出现运行时异常，S2 服务代码正确 -------->
	 * @param name
	 * @param age
	 */
	@Override
	@LcnTransaction //分布式事务注解
	@Transactional //本地事务注解
	public void s1WithExceptionAfterCallS2(String name, Integer age) {
		User u = new User();
		u.setAge(age);
		u.setName(name);
		userMapper.add(u);
		Long userID = u.getId();
		serviceBClient.addUserRole(userID,3);
		int i = 20/0;
		serviceCClient.add("a-b-c success");
	}

	/**
	 * 场景描述： S1-> S2 -> S3
	 * S1、S2  服务代码正确，S3 服务出现异常
	 * 预期结果：S1、S2、S3 事务回滚
	 *
	 * @param name
	 * @param age
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/4/1 15:48
	 */
	@Override
	@LcnTransaction //分布式事务注解
	@Transactional //本地事务注解
	public void s1ToS2ToS3WithRuntimeException(String name, Integer age) {
		User u = new User();
		u.setAge(age);
		u.setName(name);
		userMapper.add(u);
		Long userID = u.getId();
		serviceBClient.addUserRole(userID,3);
		serviceCClient.addWithRuntimeException("a-b-c success");
	}

	/**
	 * 场景描述： S1-> S2 -> S3
	 * S1 服务在调用S3 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
	 * 预期结果：	S1、S2 、S3 事务回滚
	 *
	 * @param name
	 * @param age
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/4/1 15:58
	 */
	@Override
	@LcnTransaction //分布式事务注解
	@Transactional //本地事务注解
	public void s1WithExceptionAfterCallS3(String name, Integer age) {
		User u = new User();
		u.setAge(age);
		u.setName(name);
		userMapper.add(u);
		Long userID = u.getId();
		serviceBClient.addUserRole(userID,3);
		serviceCClient.add("a-b-c success");
		int i = 20/0;
	}
}
