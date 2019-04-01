package com.hongjiaoliu.lcn.service;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/28 14:15
 */
public interface UserRoleService {
	/**
	 * 正确逻辑
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	void addUserRole(Long userID, Integer role);
	/**
	 * 代码错误，例如出现 20/0
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	void addUserRoleWithRuntimeException(Long userID, Integer role);
	/**
	 * sql 错误
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:44
	 */
	void addUserRoleWithSqlException(Long userID, Integer role);
}
