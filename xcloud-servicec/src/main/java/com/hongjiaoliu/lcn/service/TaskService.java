package com.hongjiaoliu.lcn.service;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/4/1 14:00
 */

public interface TaskService {

	void add(String id, String taskContent);
	void addWithRuntimeException(String id, String taskContent);
}
