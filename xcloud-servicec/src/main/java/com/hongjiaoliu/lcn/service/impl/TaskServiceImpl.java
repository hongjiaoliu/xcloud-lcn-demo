package com.hongjiaoliu.lcn.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.hongjiaoliu.lcn.entity.TaskLogBean;
import com.hongjiaoliu.lcn.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author liuhongjao
 * @date 2019/4/1 14:00
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	@TccTransaction(propagation = DTXPropagation.SUPPORTS,confirmMethod = "cm",cancelMethod = "cl",executeClass = TaskServiceImpl.class)
	@Transactional
	public void add(String id, String taskContent) {
		String groupId = TracingContext.tracing().groupId();
		TaskLogBean bean = new TaskLogBean();
		bean.setLogID(id);
		bean.setCreated(new Date());
		bean.setStatus(1);//添加中
		bean.setTxGroupID(groupId);
		bean.setTaskContent(taskContent);
		mongoTemplate.insert(bean);
		log.info("tcc-try-" + groupId);

	}

	/**
	* 确认方法体
	* @return:
	* @author:liuhongjiao
	* @date: 2019/4/2 13:43
	*/
	public void cm(String id, String taskContent) {
		updateMongoTaskStatus(id, 2);
		log.info("tcc-confirm-" + TracingContext.tracing().groupId());
	}

	/**
	*  取消方法体
	* @return:
	* @author:liuhongjiao
	* @date: 2019/4/2 13:43
	*/
	public void cl(String id, String taskContent) {
		updateMongoTaskStatus(id, 3);
		log.info("tcc-cancel-" + TracingContext.tracing().groupId());
	}

	@Override
	@TccTransaction(propagation = DTXPropagation.SUPPORTS,confirmMethod = "cm",cancelMethod = "cl",executeClass = TaskServiceImpl.class)
	@Transactional
	public void addWithRuntimeException(String id, String taskContent) {
		log.info("tcc-try-before-exception" + TracingContext.tracing().groupId());
		int i = 20/0;
		log.info("tcc-try-after-exception" + TracingContext.tracing().groupId());
	}

	private void updateMongoTaskStatus(String id, int i) {
		Criteria c = new Criteria();
		c.and("logID").is(id);
		Query query = Query.query(c);
		Update update = Update.update("status", i);
		mongoTemplate.updateFirst(query, update, TaskLogBean.class);
	}

}
