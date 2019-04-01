package com.hongjiaoliu.lcn.entity;

import lombok.Data;

/**
 * @author liuhongjao
 * @date 2019/4/1 16:27
 */
@Data
public class RedisTaskBean {
	private String id;
	private String taskContent;
	private Integer status;//0:未处理；1：添加中；2：添加完成；
}
