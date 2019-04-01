package com.hongjiaoliu.lcn.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.hongjiaoliu.lcn.mapper.UserRoleMapper;
import com.hongjiaoliu.lcn.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author liuhongjao
 * @date 2019/3/28 21:17
 */
@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleMapper userRoleMapper;

	/**
	 * 正确逻辑
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	@Override
	@Transactional
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	public void addUserRole(Long userID, Integer role) {
		userRoleMapper.addUserRole(userID,role,new Date());
	}

	/**
	 * 代码错误，例如出现 20/0
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:43
	 */
	@Override
	@Transactional
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	public void addUserRoleWithRuntimeException(Long userID, Integer role) {
		userRoleMapper.addUserRole(userID,role,new Date());
		int i = 20/0;
	}

	/**
	 * sql 错误
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/3/29 16:44
	 */
	@Override
	@Transactional
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	public void addUserRoleWithSqlException(Long userID, Integer role) {
		userRoleMapper.addUserRoleWithSqlError(userID,role,new Date());
	}

}
