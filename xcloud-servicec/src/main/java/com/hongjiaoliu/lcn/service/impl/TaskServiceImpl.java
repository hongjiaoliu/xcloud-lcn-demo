package com.hongjiaoliu.lcn.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.hongjiaoliu.lcn.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuhongjao
 * @date 2019/4/1 14:00
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

	@Override
	@TccTransaction(propagation = DTXPropagation.SUPPORTS,confirmMethod = "cm",cancelMethod = "cl",executeClass = TaskServiceImpl.class)
	@Transactional
	public void add(String taskContent) {
		log.info("tcc-try-" + TracingContext.tracing().groupId());
	}

	public void cm(String name) {
		log.info("tcc-confirm-" + TracingContext.tracing().groupId());
	}

	public void cl(String name) {
		log.info("tcc-cancel-" + TracingContext.tracing().groupId());
	}

	@Override
	@TccTransaction(propagation = DTXPropagation.SUPPORTS,confirmMethod = "cm",cancelMethod = "cl",executeClass = TaskServiceImpl.class)
	@Transactional
	public void addWithRuntimeException(String taskContent) {
		log.info("tcc-try-before-exception" + TracingContext.tracing().groupId());
		int i = 20/0;
		log.info("tcc-try-after-exception" + TracingContext.tracing().groupId());
	}

}
