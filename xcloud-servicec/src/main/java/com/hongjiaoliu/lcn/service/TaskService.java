package com.hongjiaoliu.lcn.service;

import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author:liuhongjiao
 * @date: 2019/4/1 14:00
 */

public interface TaskService {

	void add(String taskContent);
	void addWithRuntimeException(String taskContent);
}
