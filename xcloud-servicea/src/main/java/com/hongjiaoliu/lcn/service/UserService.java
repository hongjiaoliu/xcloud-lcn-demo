package com.hongjiaoliu.lcn.service;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/28 14:15
 */
public interface UserService {
	/**
	 * 场景1 ： S1 服务代码正确，S2 服务代码正确，------> S1 和 S2均可以顺利提交事务
	 * @param name
	 * @param age
	 */
	void addUser1(String name ,Integer age);
	/**
	 * 场景2 ： S1 服务代码正确，S2 出现运行时异常，-------> S1 和 S2 事务回滚
	 * @param name
	 * @param age
	 */
	void addUser2(String name ,Integer age);
	/**
	 * 场景3：  S1 服务在调用S2 服务后出现运行时异常，S2 服务代码正确 -------->
	 * @param name
	 * @param age
	 */
	void addUser3(String name ,Integer age);

}
