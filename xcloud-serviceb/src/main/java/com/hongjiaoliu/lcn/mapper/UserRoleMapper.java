package com.hongjiaoliu.lcn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/29 15:51
 */
@Mapper
@Repository
public interface UserRoleMapper {
	void addUserRole(@Param("userID") Long userID,@Param("role") int role);
	void addUserRoleWithSqlError(@Param("userID") Long userID,@Param("role") int role);
}
