package com.hongjiaoliu.lcn.mapper;

import com.hongjiaoliu.lcn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/3/28 14:06
 */
@Mapper
@Repository
public interface UserMapper {

	void add(@Param("user") User user);

	User getUserByID(@Param("id") Long ID);

}
