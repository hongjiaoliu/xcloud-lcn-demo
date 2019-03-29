package com.hongjiaoliu.lcn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liuhongjao
 * @date 2019/3/29 16:06
 */
@Setter
@Getter
@AllArgsConstructor
public class UserRole {
	Integer id;
	Long userID;
	Integer role;
	String roleName;
}
