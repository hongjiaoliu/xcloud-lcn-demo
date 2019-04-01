package com.hongjiaoliu.lcn.service;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/28 14:15
 */
public interface UserService {
	/**
	 * 场景描述：S1-> S2 -> S3
	 * 		S1、S2、S3 服务代码均正确
	 * 	预期结果：S1、S2、S3均可顺利提交事务
	 * @param name
	 * @param age
	 */
	void s1ToS2ToS3(String name , Integer age);
	/**
	 *  场景描述：S1-> S2 -> S3
	 * 		S1 服务代码正确，S2 出现运行时异常，S3服务代码正确
	 * 	预期结果：S1、S2 事务回滚，不调用S3（这里涉不涉及字节码重排序？）
	 * @param name
	 * @param age
	 */
	void s1ToS2withRuntimeExceptionToS3(String name , Integer age);

	/**
	* 场景描述： S1-> S2 -> S3
	 * 		S1、S2  服务代码正确，S3 服务出现异常
	 * 	预期结果：S1、S2、S3 事务回滚
	* @return:
	* @author:liuhongjiao
	* @date: 2019/4/1 15:48
	*/
	void s1ToS2ToS3WithRuntimeException(String name , Integer age);

	/**
	 * 场景描述： S1-> S2 -> S3
	 * 		S1 服务在调用S2 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
	 * 	预期结果：	S1、S2 事务回滚，不调用S3
	 * @param name
	 * @param age
	 */
	void s1WithExceptionAfterCallS2(String name , Integer age);

	/**
	* 场景描述： S1-> S2 -> S3
	 *  	S1 服务在调用S3 服务后出现运行时异常，S2 服务代码正确，S3服务代码正确
	 *  预期结果：	S1、S2 、S3 事务回滚
	* @return:
	* @author:liuhongjiao
	* @date: 2019/4/1 15:58
	*/
	void s1WithExceptionAfterCallS3(String name , Integer age);



}
