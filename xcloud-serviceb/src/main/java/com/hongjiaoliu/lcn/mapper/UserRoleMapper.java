package com.hongjiaoliu.lcn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/29 15:51
 */
@Mapper
@Repository
public interface UserRoleMapper {
	void addUserRole(@Param("userID") Long userID, @Param("role") int role, @Param("created") Date created);
	void addUserRoleWithSqlError(@Param("userID") Long userID,@Param("role") int role, @Param("created") Date created);
}
