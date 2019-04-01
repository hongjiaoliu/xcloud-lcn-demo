package com.hongjiaoliu.lcn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author liuhongjao
 * @date 2019/3/29 16:05
 */
@Setter
@Getter
public class User {
	Long id;
	String name;
	Integer age;
	Date created;
}
